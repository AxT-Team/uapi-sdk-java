package uapi;

import com.google.gson.*;
import okhttp3.Headers;
import java.util.HashMap;
import java.util.Map;

public class UapiException extends Exception {
    public final String code;
    public final int status;
    public final JsonElement details;
    public final JsonElement payload;
    public final ResponseMeta meta;

    public UapiException(String code, int status, String message, JsonElement details, JsonElement payload, ResponseMeta meta) {
        super("[" + status + "] " + code + ": " + message);
        this.code = code;
        this.status = status;
        this.details = details;
        this.payload = payload;
        this.meta = meta;
    }

    public static UapiException map(int status, String body, Headers headers) {
        ResponseMeta meta = extractMeta(headers);
        try {
            JsonElement parsed = JsonParser.parseString(body);
            JsonObject o = parsed.isJsonObject() ? parsed.getAsJsonObject() : new JsonObject();
            String code = readString(o, "code");
            if (code == null || code.isBlank()) {
                code = readString(o, "error");
            }
            if (code == null || code.isBlank()) {
                code = defaultCode(status);
            }
            String msg = o.has("message") ? o.get("message").getAsString() : "";
            if (msg == null || msg.isBlank()) {
                msg = body;
            }
            JsonElement details = pickDetails(o);
            return create(code, status, msg, details, parsed, meta);
        } catch (Exception e) {
            return create(defaultCode(status), status, body, JsonNull.INSTANCE, JsonNull.INSTANCE, meta);
        }
    }

    private static UapiException create(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) {
        switch (code.toUpperCase()) {
            case "API_ERROR": return new ApiError(code, status, msg, details, payload, meta);
            case "AVATAR_NOT_FOUND": return new AvatarNotFound(code, status, msg, details, payload, meta);
            case "CONVERSION_FAILED": return new ConversionFailed(code, status, msg, details, payload, meta);
            case "FILE_OPEN_ERROR": return new FileOpenError(code, status, msg, details, payload, meta);
            case "FILE_REQUIRED": return new FileRequired(code, status, msg, details, payload, meta);
            case "INSUFFICIENT_CREDITS": return new InsufficientCredits(code, status, msg, details, payload, meta);
            case "INTERNAL_SERVER_ERROR": return new InternalServerError(code, status, msg, details, payload, meta);
            case "INVALID_PARAMETER": return new InvalidParameter(code, status, msg, details, payload, meta);
            case "INVALID_PARAMS": return new InvalidParams(code, status, msg, details, payload, meta);
            case "NOT_FOUND": return new NotFound(code, status, msg, details, payload, meta);
            case "NO_MATCH": return new NoMatch(code, status, msg, details, payload, meta);
            case "NO_TRACKING_DATA": return new NoTrackingData(code, status, msg, details, payload, meta);
            case "PHONE_INFO_FAILED": return new PhoneInfoFailed(code, status, msg, details, payload, meta);
            case "RECOGNITION_FAILED": return new RecognitionFailed(code, status, msg, details, payload, meta);
            case "REQUEST_ENTITY_TOO_LARGE": return new RequestEntityTooLarge(code, status, msg, details, payload, meta);
            case "SERVICE_BUSY": return new ServiceBusy(code, status, msg, details, payload, meta);
            case "TIMEZONE_NOT_FOUND": return new TimezoneNotFound(code, status, msg, details, payload, meta);
            case "UNAUTHORIZED": return new Unauthorized(code, status, msg, details, payload, meta);
            case "UNSUPPORTED_CARRIER": return new UnsupportedCarrier(code, status, msg, details, payload, meta);
            case "UNSUPPORTED_FORMAT": return new UnsupportedFormat(code, status, msg, details, payload, meta);
            case "VISITOR_MONTHLY_QUOTA_EXHAUSTED": return new VisitorMonthlyQuotaExhausted(code, status, msg, details, payload, meta);
            default: return new UapiException(code, status, msg, details, payload, meta);
        }
    }

    private static String defaultCode(int status) {
        return switch (status) {
            case 400 -> "INVALID_PARAMETER";
            case 401 -> "UNAUTHORIZED";
            case 402 -> "INSUFFICIENT_CREDITS";
            case 404 -> "NOT_FOUND";
            case 429 -> "SERVICE_BUSY";
            case 500 -> "INTERNAL_SERVER_ERROR";
            default -> "API_ERROR";
        };
    }

    private static String readString(JsonObject o, String key) {
        if (!o.has(key) || o.get(key).isJsonNull()) {
            return null;
        }
        return o.get(key).getAsString();
    }

    private static JsonElement pickDetails(JsonObject o) {
        if (o.has("details")) {
            return o.get("details");
        }
        if (o.has("quota")) {
            return o.get("quota");
        }
        if (o.has("docs")) {
            return o.get("docs");
        }
        return JsonNull.INSTANCE;
    }

    public static ResponseMeta extractMeta(Headers headers) {
        Map<String, String> raw = new HashMap<>();
        for (int i = 0; i < headers.size(); i++) {
            raw.put(headers.name(i).toLowerCase(), headers.value(i));
        }

        ResponseMeta meta = new ResponseMeta();
        meta.requestId = raw.get("x-request-id");
        meta.retryAfterRaw = raw.get("retry-after");
        meta.retryAfterSeconds = parseInteger(raw.get("retry-after"));
        meta.debitStatus = raw.get("uapi-debit-status");
        meta.creditsRequested = parseLong(raw.get("uapi-credits-requested"));
        meta.creditsCharged = parseLong(raw.get("uapi-credits-charged"));
        meta.creditsPricing = raw.get("uapi-credits-pricing");
        meta.activeQuotaBuckets = parseInteger(raw.get("uapi-quota-active-buckets"));
        meta.stopOnEmpty = parseBoolean(raw.get("uapi-stop-on-empty"));
        meta.rateLimitPolicyRaw = raw.get("ratelimit-policy");
        meta.rateLimitRaw = raw.get("ratelimit");
        meta.rawHeaders = raw;

        for (StructuredItem item : parseStructuredItems(meta.rateLimitPolicyRaw)) {
            RateLimitPolicyEntry entry = new RateLimitPolicyEntry();
            entry.name = item.name;
            entry.quota = parseLong(item.params.get("q"));
            entry.unit = item.params.get("uapi-unit");
            entry.windowSeconds = parseInteger(item.params.get("w"));
            meta.rateLimitPolicies.put(item.name, entry);
        }

        for (StructuredItem item : parseStructuredItems(meta.rateLimitRaw)) {
            RateLimitStateEntry entry = new RateLimitStateEntry();
            entry.name = item.name;
            entry.remaining = parseLong(item.params.get("r"));
            entry.unit = item.params.get("uapi-unit");
            entry.resetAfterSeconds = parseInteger(item.params.get("t"));
            meta.rateLimits.put(item.name, entry);
        }

        if (meta.rateLimitPolicies.containsKey("billing-balance")) {
            meta.balanceLimitCents = meta.rateLimitPolicies.get("billing-balance").quota;
        }
        if (meta.rateLimits.containsKey("billing-balance")) {
            meta.balanceRemainingCents = meta.rateLimits.get("billing-balance").remaining;
        }
        if (meta.rateLimitPolicies.containsKey("billing-quota")) {
            meta.quotaLimitCredits = meta.rateLimitPolicies.get("billing-quota").quota;
        }
        if (meta.rateLimits.containsKey("billing-quota")) {
            meta.quotaRemainingCredits = meta.rateLimits.get("billing-quota").remaining;
        }
        if (meta.rateLimitPolicies.containsKey("visitor-quota")) {
            meta.visitorQuotaLimitCredits = meta.rateLimitPolicies.get("visitor-quota").quota;
        }
        if (meta.rateLimits.containsKey("visitor-quota")) {
            meta.visitorQuotaRemainingCredits = meta.rateLimits.get("visitor-quota").remaining;
        }
        if (meta.rateLimitPolicies.containsKey("billing-key-rate")) {
            RateLimitPolicyEntry entry = meta.rateLimitPolicies.get("billing-key-rate");
            meta.billingKeyRateLimit = entry.quota;
            meta.billingKeyRateUnit = entry.unit;
            meta.billingKeyRateWindowSeconds = entry.windowSeconds;
        }
        if (meta.rateLimits.containsKey("billing-key-rate")) {
            RateLimitStateEntry entry = meta.rateLimits.get("billing-key-rate");
            meta.billingKeyRateRemaining = entry.remaining;
            if (meta.billingKeyRateUnit == null || meta.billingKeyRateUnit.isBlank()) {
                meta.billingKeyRateUnit = entry.unit;
            }
            meta.billingKeyRateResetAfterSeconds = entry.resetAfterSeconds;
        }
        if (meta.rateLimitPolicies.containsKey("billing-ip-rate")) {
            RateLimitPolicyEntry entry = meta.rateLimitPolicies.get("billing-ip-rate");
            meta.billingIpRateLimit = entry.quota;
            meta.billingIpRateUnit = entry.unit;
            meta.billingIpRateWindowSeconds = entry.windowSeconds;
        }
        if (meta.rateLimits.containsKey("billing-ip-rate")) {
            RateLimitStateEntry entry = meta.rateLimits.get("billing-ip-rate");
            meta.billingIpRateRemaining = entry.remaining;
            if (meta.billingIpRateUnit == null || meta.billingIpRateUnit.isBlank()) {
                meta.billingIpRateUnit = entry.unit;
            }
            meta.billingIpRateResetAfterSeconds = entry.resetAfterSeconds;
        }
        if (meta.rateLimitPolicies.containsKey("visitor-rate")) {
            RateLimitPolicyEntry entry = meta.rateLimitPolicies.get("visitor-rate");
            meta.visitorRateLimit = entry.quota;
            meta.visitorRateUnit = entry.unit;
            meta.visitorRateWindowSeconds = entry.windowSeconds;
        }
        if (meta.rateLimits.containsKey("visitor-rate")) {
            RateLimitStateEntry entry = meta.rateLimits.get("visitor-rate");
            meta.visitorRateRemaining = entry.remaining;
            if (meta.visitorRateUnit == null || meta.visitorRateUnit.isBlank()) {
                meta.visitorRateUnit = entry.unit;
            }
            meta.visitorRateResetAfterSeconds = entry.resetAfterSeconds;
        }
        return meta;
    }

    private static Integer parseInteger(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException ignore) {
            return null;
        }
    }

    private static Long parseLong(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            return Long.parseLong(value.trim());
        } catch (NumberFormatException ignore) {
            return null;
        }
    }

    private static Boolean parseBoolean(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        String normalized = value.trim().toLowerCase();
        if ("true".equals(normalized)) {
            return true;
        }
        if ("false".equals(normalized)) {
            return false;
        }
        return null;
    }

    private static StructuredItem[] parseStructuredItems(String raw) {
        if (raw == null || raw.isBlank()) {
            return new StructuredItem[0];
        }
        String[] chunks = raw.split(",");
        StructuredItem[] items = new StructuredItem[chunks.length];
        int count = 0;
        for (String chunk : chunks) {
            if (chunk == null || chunk.isBlank()) {
                continue;
            }
            String[] parts = chunk.trim().split(";");
            if (parts.length == 0) {
                continue;
            }
            StructuredItem item = new StructuredItem();
            item.name = unquote(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                String part = parts[i].trim();
                int eq = part.indexOf('=');
                if (eq <= 0) {
                    continue;
                }
                item.params.put(part.substring(0, eq).trim(), unquote(part.substring(eq + 1)));
            }
            items[count++] = item;
        }
        StructuredItem[] compact = new StructuredItem[count];
        System.arraycopy(items, 0, compact, 0, count);
        return compact;
    }

    private static String unquote(String value) {
        String text = value == null ? "" : value.trim();
        if (text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }

    private static class StructuredItem {
        String name;
        Map<String, String> params = new HashMap<>();
    }

    public static class RateLimitPolicyEntry {
        public String name;
        public Long quota;
        public String unit;
        public Integer windowSeconds;
    }

    public static class RateLimitStateEntry {
        public String name;
        public Long remaining;
        public String unit;
        public Integer resetAfterSeconds;
    }

    public static class ResponseMeta {
        public String requestId;
        public String retryAfterRaw;
        public Integer retryAfterSeconds;
        public String debitStatus;
        public Long creditsRequested;
        public Long creditsCharged;
        public String creditsPricing;
        public Integer activeQuotaBuckets;
        public Boolean stopOnEmpty;
        public String rateLimitPolicyRaw;
        public String rateLimitRaw;
        public Map<String, RateLimitPolicyEntry> rateLimitPolicies = new HashMap<>();
        public Map<String, RateLimitStateEntry> rateLimits = new HashMap<>();
        public Long balanceLimitCents;
        public Long balanceRemainingCents;
        public Long quotaLimitCredits;
        public Long quotaRemainingCredits;
        public Long visitorQuotaLimitCredits;
        public Long visitorQuotaRemainingCredits;
        public Long billingKeyRateLimit;
        public Long billingKeyRateRemaining;
        public String billingKeyRateUnit;
        public Integer billingKeyRateWindowSeconds;
        public Integer billingKeyRateResetAfterSeconds;
        public Long billingIpRateLimit;
        public Long billingIpRateRemaining;
        public String billingIpRateUnit;
        public Integer billingIpRateWindowSeconds;
        public Integer billingIpRateResetAfterSeconds;
        public Long visitorRateLimit;
        public Long visitorRateRemaining;
        public String visitorRateUnit;
        public Integer visitorRateWindowSeconds;
        public Integer visitorRateResetAfterSeconds;
        public Map<String, String> rawHeaders = new HashMap<>();
    }
    public static class ApiError extends UapiException {
        public ApiError(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class AvatarNotFound extends UapiException {
        public AvatarNotFound(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class ConversionFailed extends UapiException {
        public ConversionFailed(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class FileOpenError extends UapiException {
        public FileOpenError(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class FileRequired extends UapiException {
        public FileRequired(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class InsufficientCredits extends UapiException {
        public InsufficientCredits(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class InternalServerError extends UapiException {
        public InternalServerError(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class InvalidParameter extends UapiException {
        public InvalidParameter(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class InvalidParams extends UapiException {
        public InvalidParams(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class NotFound extends UapiException {
        public NotFound(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class NoMatch extends UapiException {
        public NoMatch(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class NoTrackingData extends UapiException {
        public NoTrackingData(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class PhoneInfoFailed extends UapiException {
        public PhoneInfoFailed(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class RecognitionFailed extends UapiException {
        public RecognitionFailed(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class RequestEntityTooLarge extends UapiException {
        public RequestEntityTooLarge(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class ServiceBusy extends UapiException {
        public ServiceBusy(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class TimezoneNotFound extends UapiException {
        public TimezoneNotFound(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class Unauthorized extends UapiException {
        public Unauthorized(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class UnsupportedCarrier extends UapiException {
        public UnsupportedCarrier(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class UnsupportedFormat extends UapiException {
        public UnsupportedFormat(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
    public static class VisitorMonthlyQuotaExhausted extends UapiException {
        public VisitorMonthlyQuotaExhausted(String code, int status, String msg, JsonElement details, JsonElement payload, ResponseMeta meta) { super(code, status, msg, details, payload, meta); }
    }
}
