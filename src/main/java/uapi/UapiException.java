package uapi;

import com.google.gson.*;

public class UapiException extends Exception {
    public final String code;
    public final int status;
    public final JsonElement details;

    public UapiException(String code, int status, String message, JsonElement details) {
        super("[" + status + "] " + code + ": " + message);
        this.code = code; this.status = status; this.details = details;
    }

    public static UapiException map(int status, String body) {
        try {
            JsonObject o = JsonParser.parseString(body).getAsJsonObject();
            String code = o.has("code") ? o.get("code").getAsString() : defaultCode(status);
            String msg = o.has("message") ? o.get("message").getAsString() : "";
            JsonElement details = o.has("details") ? o.get("details") : JsonNull.INSTANCE;
            return create(code, status, msg, details);
        } catch (Exception e) {
            return create(defaultCode(status), status, body, JsonNull.INSTANCE);
        }
    }

    private static UapiException create(String code, int status, String msg, JsonElement details) {
        switch (code.toUpperCase()) {
            case "API_ERROR": return new ApiError(code, status, msg, details);
            case "AVATAR_NOT_FOUND": return new AvatarNotFound(code, status, msg, details);
            case "CONVERSION_FAILED": return new ConversionFailed(code, status, msg, details);
            case "FILE_OPEN_ERROR": return new FileOpenError(code, status, msg, details);
            case "FILE_REQUIRED": return new FileRequired(code, status, msg, details);
            case "INTERNAL_SERVER_ERROR": return new InternalServerError(code, status, msg, details);
            case "INVALID_PARAMETER": return new InvalidParameter(code, status, msg, details);
            case "INVALID_PARAMS": return new InvalidParams(code, status, msg, details);
            case "NOT_FOUND": return new NotFound(code, status, msg, details);
            case "NO_MATCH": return new NoMatch(code, status, msg, details);
            case "NO_TRACKING_DATA": return new NoTrackingData(code, status, msg, details);
            case "PHONE_INFO_FAILED": return new PhoneInfoFailed(code, status, msg, details);
            case "RECOGNITION_FAILED": return new RecognitionFailed(code, status, msg, details);
            case "REQUEST_ENTITY_TOO_LARGE": return new RequestEntityTooLarge(code, status, msg, details);
            case "SERVICE_BUSY": return new ServiceBusy(code, status, msg, details);
            case "TIMEZONE_NOT_FOUND": return new TimezoneNotFound(code, status, msg, details);
            case "UNAUTHORIZED": return new Unauthorized(code, status, msg, details);
            case "UNSUPPORTED_CARRIER": return new UnsupportedCarrier(code, status, msg, details);
            case "UNSUPPORTED_FORMAT": return new UnsupportedFormat(code, status, msg, details);
            default: return new UapiException(code, status, msg, details);
        }
    }

    private static String defaultCode(int status) {
        return switch (status) {
            case 400 -> "INVALID_PARAMETER";
            case 401 -> "UNAUTHORIZED";
            case 404 -> "NOT_FOUND";
            case 429 -> "SERVICE_BUSY";
            case 500 -> "INTERNAL_SERVER_ERROR";
            default -> "API_ERROR";
        };
    }
    public static class ApiError extends UapiException {
        public ApiError(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class AvatarNotFound extends UapiException {
        public AvatarNotFound(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class ConversionFailed extends UapiException {
        public ConversionFailed(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class FileOpenError extends UapiException {
        public FileOpenError(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class FileRequired extends UapiException {
        public FileRequired(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class InternalServerError extends UapiException {
        public InternalServerError(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class InvalidParameter extends UapiException {
        public InvalidParameter(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class InvalidParams extends UapiException {
        public InvalidParams(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class NotFound extends UapiException {
        public NotFound(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class NoMatch extends UapiException {
        public NoMatch(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class NoTrackingData extends UapiException {
        public NoTrackingData(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class PhoneInfoFailed extends UapiException {
        public PhoneInfoFailed(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class RecognitionFailed extends UapiException {
        public RecognitionFailed(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class RequestEntityTooLarge extends UapiException {
        public RequestEntityTooLarge(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class ServiceBusy extends UapiException {
        public ServiceBusy(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class TimezoneNotFound extends UapiException {
        public TimezoneNotFound(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class Unauthorized extends UapiException {
        public Unauthorized(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class UnsupportedCarrier extends UapiException {
        public UnsupportedCarrier(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
    public static class UnsupportedFormat extends UapiException {
        public UnsupportedFormat(String code, int status, String msg, JsonElement details) { super(code, status, msg, details); }
    }
}
