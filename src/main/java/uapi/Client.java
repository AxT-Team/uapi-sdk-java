package uapi;

import okhttp3.*;
import com.google.gson.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private final String baseUrl;
    private final String token;
    private final OkHttpClient http = new OkHttpClient();
    private final boolean disableCacheDefault;
    private volatile UapiException.ResponseMeta lastResponseMeta;

    public static class ClientOptions {
        private boolean disableCache;

        public ClientOptions disableCache(boolean disableCache) {
            this.disableCache = disableCache;
            return this;
        }
    }

    public Client(String baseUrl, String token) { this(baseUrl, token, null); }

    public Client(String baseUrl, String token, ClientOptions options) {
        this.baseUrl = normalizeBaseUrl(baseUrl);
        this.token = token;
        this.disableCacheDefault = options != null && options.disableCache;
    }

    public UapiException.ResponseMeta getLastResponseMeta() { return lastResponseMeta; }

    private static String normalizeBaseUrl(String baseUrl) {
        var normalized = baseUrl.replaceAll("/+$", "");
        return normalized.endsWith("/api/v1") ? normalized.substring(0, normalized.length() - "/api/v1".length()) : normalized;
    }

    private static Boolean coerceBoolean(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Boolean boolValue) {
            return boolValue;
        }
        if (value instanceof Number numberValue) {
            return numberValue.doubleValue() != 0;
        }
        if (value instanceof String textValue) {
            var normalized = textValue.trim().toLowerCase();
            if ("1".equals(normalized) || "true".equals(normalized) || "yes".equals(normalized) || "on".equals(normalized)) {
                return true;
            }
            if ("0".equals(normalized) || "false".equals(normalized) || "no".equals(normalized) || "off".equals(normalized)) {
                return false;
            }
        }
        return null;
    }

    private static Boolean readDisableCache(Map<String, Object> args) {
        if (args == null) {
            return null;
        }
        if (args.containsKey("disableCache")) {
            return coerceBoolean(args.get("disableCache"));
        }
        if (args.containsKey("disable_cache")) {
            return coerceBoolean(args.get("disable_cache"));
        }
        return null;
    }

    private Map<String, Object> applyCacheControl(String method, Map<String, Object> params, Boolean disableCache) {
        if (!"GET".equalsIgnoreCase(method)) {
            return params;
        }
        if (params != null && params.containsKey("_t") && params.get("_t") != null) {
            return params;
        }
        var effectiveDisableCache = disableCache != null ? disableCache : disableCacheDefault;
        if (!effectiveDisableCache) {
            return params;
        }
        var query = params == null ? new HashMap<String, Object>() : new HashMap<>(params);
        query.put("_t", System.currentTimeMillis());
        return query;
    }

    private Object request(String method, String path, Map<String, Object> params, Object body, Boolean disableCache) throws UapiException, IOException {
        params = applyCacheControl(method, params, disableCache);
        HttpUrl.Builder url = HttpUrl.parse(baseUrl + path).newBuilder();
        if (params != null) for (var e: params.entrySet()) url.addQueryParameter(e.getKey(), String.valueOf(e.getValue()));
        RequestBody reqBody = body == null ? null : RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(body));
        Request.Builder req = new Request.Builder().url(url.build());
        req.method(method, reqBody);
        if (token != null && !token.isEmpty()) req.addHeader("Authorization", "Bearer " + token);
        Response resp = http.newCall(req.build()).execute();
        String ct = resp.header("content-type", "");
        String text = resp.body() == null ? "" : resp.body().string();
        lastResponseMeta = UapiException.extractMeta(resp.headers());
        if (!resp.isSuccessful()) throw UapiException.map(resp.code(), text, resp.headers());
        if (ct.contains("application/json")) return new Gson().fromJson(text, Object.class);
        return text;
    }
    public ClipzyZaiXianJianTieBanApi clipzyZaiXianJianTieBan() { return new ClipzyZaiXianJianTieBanApi(); }
    public class ClipzyZaiXianJianTieBanApi {
        public Object getClipzyGet(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("id")) q.put("id", args.get("id"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/api/get";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getClipzyRaw(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("path".equals("query") && args != null && args.containsKey("id")) q.put("id", args.get("id"));
            if ("query".equals("query") && args != null && args.containsKey("key")) q.put("key", args.get("key"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/api/raw/{id}";
            if (args != null && args.containsKey("id")) path = path.replace("{" + "id" + "}", String.valueOf(args.get("id")));
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postClipzyStore(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("compressedData")) body.put("compressedData", args.get("compressedData"));
            if (args != null && args.containsKey("ttl")) body.put("ttl", args.get("ttl"));
            String path = "/api/v1/api/store";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public ConvertApi convert() { return new ConvertApi(); }
    public class ConvertApi {
        public Object getConvertUnixtime(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("time")) q.put("time", args.get("time"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/convert/unixtime";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postConvertJson(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("content")) body.put("content", args.get("content"));
            String path = "/api/v1/convert/json";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public DailyApi daily() { return new DailyApi(); }
    public class DailyApi {
        public Object getDailyNewsImage(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/daily/news-image";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public GameApi game() { return new GameApi(); }
    public class GameApi {
        public Object getGameEpicFree(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/game/epic-free";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getGameMinecraftHistoryid(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("name")) q.put("name", args.get("name"));
            if ("query".equals("query") && args != null && args.containsKey("uuid")) q.put("uuid", args.get("uuid"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/game/minecraft/historyid";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getGameMinecraftServerstatus(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("server")) q.put("server", args.get("server"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/game/minecraft/serverstatus";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getGameMinecraftUserinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("username")) q.put("username", args.get("username"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/game/minecraft/userinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getGameSteamSummary(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("steamid")) q.put("steamid", args.get("steamid"));
            if ("query".equals("query") && args != null && args.containsKey("id")) q.put("id", args.get("id"));
            if ("query".equals("query") && args != null && args.containsKey("id3")) q.put("id3", args.get("id3"));
            if ("query".equals("query") && args != null && args.containsKey("key")) q.put("key", args.get("key"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/game/steam/summary";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public ImageApi image() { return new ImageApi(); }
    public class ImageApi {
        public Object getAvatarGravatar(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("email")) q.put("email", args.get("email"));
            if ("query".equals("query") && args != null && args.containsKey("hash")) q.put("hash", args.get("hash"));
            if ("query".equals("query") && args != null && args.containsKey("s")) q.put("s", args.get("s"));
            if ("query".equals("query") && args != null && args.containsKey("d")) q.put("d", args.get("d"));
            if ("query".equals("query") && args != null && args.containsKey("r")) q.put("r", args.get("r"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/avatar/gravatar";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getImageBingDaily(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("date")) q.put("date", args.get("date"));
            if ("query".equals("query") && args != null && args.containsKey("resolution")) q.put("resolution", args.get("resolution"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/image/bing-daily";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getImageBingDailyHistory(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("date")) q.put("date", args.get("date"));
            if ("query".equals("query") && args != null && args.containsKey("resolution")) q.put("resolution", args.get("resolution"));
            if ("query".equals("query") && args != null && args.containsKey("page")) q.put("page", args.get("page"));
            if ("query".equals("query") && args != null && args.containsKey("page_size")) q.put("page_size", args.get("page_size"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/image/bing-daily/history";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getImageMotou(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("qq")) q.put("qq", args.get("qq"));
            if ("query".equals("query") && args != null && args.containsKey("bg_color")) q.put("bg_color", args.get("bg_color"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/image/motou";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getImageQrcode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("text")) q.put("text", args.get("text"));
            if ("query".equals("query") && args != null && args.containsKey("size")) q.put("size", args.get("size"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if ("query".equals("query") && args != null && args.containsKey("transparent")) q.put("transparent", args.get("transparent"));
            if ("query".equals("query") && args != null && args.containsKey("fgcolor")) q.put("fgcolor", args.get("fgcolor"));
            if ("query".equals("query") && args != null && args.containsKey("bgcolor")) q.put("bgcolor", args.get("bgcolor"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/image/qrcode";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getImageTobase64(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/image/tobase64";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageCompress(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("level")) q.put("level", args.get("level"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("file")) body.put("file", args.get("file"));
            String path = "/api/v1/image/compress";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageDecode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("width")) q.put("width", args.get("width"));
            if ("query".equals("query") && args != null && args.containsKey("height")) q.put("height", args.get("height"));
            if ("query".equals("query") && args != null && args.containsKey("max_width")) q.put("max_width", args.get("max_width"));
            if ("query".equals("query") && args != null && args.containsKey("max_height")) q.put("max_height", args.get("max_height"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if ("query".equals("query") && args != null && args.containsKey("color_mode")) q.put("color_mode", args.get("color_mode"));
            if ("query".equals("query") && args != null && args.containsKey("fit")) q.put("fit", args.get("fit"));
            if ("query".equals("query") && args != null && args.containsKey("background")) q.put("background", args.get("background"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("file")) body.put("file", args.get("file"));
            if (args != null && args.containsKey("url")) body.put("url", args.get("url"));
            String path = "/api/v1/image/decode";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageFrombase64(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("imageData")) body.put("imageData", args.get("imageData"));
            String path = "/api/v1/image/frombase64";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageMotou(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("bg_color")) body.put("bg_color", args.get("bg_color"));
            if (args != null && args.containsKey("file")) body.put("file", args.get("file"));
            if (args != null && args.containsKey("image_url")) body.put("image_url", args.get("image_url"));
            String path = "/api/v1/image/motou";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageNsfw(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("file")) body.put("file", args.get("file"));
            if (args != null && args.containsKey("url")) body.put("url", args.get("url"));
            String path = "/api/v1/image/nsfw";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageOcr(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("enable_cls")) body.put("enable_cls", args.get("enable_cls"));
            if (args != null && args.containsKey("file")) body.put("file", args.get("file"));
            if (args != null && args.containsKey("image_base64")) body.put("image_base64", args.get("image_base64"));
            if (args != null && args.containsKey("image_name")) body.put("image_name", args.get("image_name"));
            if (args != null && args.containsKey("need_location")) body.put("need_location", args.get("need_location"));
            if (args != null && args.containsKey("return_markdown")) body.put("return_markdown", args.get("return_markdown"));
            if (args != null && args.containsKey("url")) body.put("url", args.get("url"));
            String path = "/api/v1/image/ocr";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageSpeechless(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("bottom_text")) body.put("bottom_text", args.get("bottom_text"));
            if (args != null && args.containsKey("top_text")) body.put("top_text", args.get("top_text"));
            String path = "/api/v1/image/speechless";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postImageSvg(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if ("query".equals("query") && args != null && args.containsKey("width")) q.put("width", args.get("width"));
            if ("query".equals("query") && args != null && args.containsKey("height")) q.put("height", args.get("height"));
            if ("query".equals("query") && args != null && args.containsKey("quality")) q.put("quality", args.get("quality"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("file")) body.put("file", args.get("file"));
            String path = "/api/v1/image/svg";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public MiscApi misc() { return new MiscApi(); }
    public class MiscApi {
        public Object getHistoryProgrammer(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("month")) q.put("month", args.get("month"));
            if ("query".equals("query") && args != null && args.containsKey("day")) q.put("day", args.get("day"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/history/programmer";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getHistoryProgrammerToday(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/history/programmer/today";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscDistrict(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("keywords")) q.put("keywords", args.get("keywords"));
            if ("query".equals("query") && args != null && args.containsKey("adcode")) q.put("adcode", args.get("adcode"));
            if ("query".equals("query") && args != null && args.containsKey("lat")) q.put("lat", args.get("lat"));
            if ("query".equals("query") && args != null && args.containsKey("lng")) q.put("lng", args.get("lng"));
            if ("query".equals("query") && args != null && args.containsKey("level")) q.put("level", args.get("level"));
            if ("query".equals("query") && args != null && args.containsKey("country")) q.put("country", args.get("country"));
            if ("query".equals("query") && args != null && args.containsKey("limit")) q.put("limit", args.get("limit"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/district";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscHolidayCalendar(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("date")) q.put("date", args.get("date"));
            if ("query".equals("query") && args != null && args.containsKey("month")) q.put("month", args.get("month"));
            if ("query".equals("query") && args != null && args.containsKey("year")) q.put("year", args.get("year"));
            if ("query".equals("query") && args != null && args.containsKey("timezone")) q.put("timezone", args.get("timezone"));
            if ("query".equals("query") && args != null && args.containsKey("holiday_type")) q.put("holiday_type", args.get("holiday_type"));
            if ("query".equals("query") && args != null && args.containsKey("include_nearby")) q.put("include_nearby", args.get("include_nearby"));
            if ("query".equals("query") && args != null && args.containsKey("nearby_limit")) q.put("nearby_limit", args.get("nearby_limit"));
            if ("query".equals("query") && args != null && args.containsKey("exclude_past")) q.put("exclude_past", args.get("exclude_past"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/holiday-calendar";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscHotboard(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            if ("query".equals("query") && args != null && args.containsKey("time")) q.put("time", args.get("time"));
            if ("query".equals("query") && args != null && args.containsKey("keyword")) q.put("keyword", args.get("keyword"));
            if ("query".equals("query") && args != null && args.containsKey("time_start")) q.put("time_start", args.get("time_start"));
            if ("query".equals("query") && args != null && args.containsKey("time_end")) q.put("time_end", args.get("time_end"));
            if ("query".equals("query") && args != null && args.containsKey("limit")) q.put("limit", args.get("limit"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/hotboard";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscLunartime(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("ts")) q.put("ts", args.get("ts"));
            if ("query".equals("query") && args != null && args.containsKey("timezone")) q.put("timezone", args.get("timezone"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/lunartime";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscPhoneinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("phone")) q.put("phone", args.get("phone"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/phoneinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscRandomnumber(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("min")) q.put("min", args.get("min"));
            if ("query".equals("query") && args != null && args.containsKey("max")) q.put("max", args.get("max"));
            if ("query".equals("query") && args != null && args.containsKey("count")) q.put("count", args.get("count"));
            if ("query".equals("query") && args != null && args.containsKey("allow_repeat")) q.put("allow_repeat", args.get("allow_repeat"));
            if ("query".equals("query") && args != null && args.containsKey("allow_decimal")) q.put("allow_decimal", args.get("allow_decimal"));
            if ("query".equals("query") && args != null && args.containsKey("decimal_places")) q.put("decimal_places", args.get("decimal_places"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/randomnumber";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscTimestamp(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("ts")) q.put("ts", args.get("ts"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/timestamp";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscTrackingCarriers(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/tracking/carriers";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscTrackingDetect(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("tracking_number")) q.put("tracking_number", args.get("tracking_number"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/tracking/detect";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscTrackingQuery(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("tracking_number")) q.put("tracking_number", args.get("tracking_number"));
            if ("query".equals("query") && args != null && args.containsKey("carrier_code")) q.put("carrier_code", args.get("carrier_code"));
            if ("query".equals("query") && args != null && args.containsKey("phone")) q.put("phone", args.get("phone"));
            if ("query".equals("query") && args != null && args.containsKey("full")) q.put("full", args.get("full"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/tracking/query";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscWeather(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("city")) q.put("city", args.get("city"));
            if ("query".equals("query") && args != null && args.containsKey("adcode")) q.put("adcode", args.get("adcode"));
            if ("query".equals("query") && args != null && args.containsKey("extended")) q.put("extended", args.get("extended"));
            if ("query".equals("query") && args != null && args.containsKey("forecast")) q.put("forecast", args.get("forecast"));
            if ("query".equals("query") && args != null && args.containsKey("hourly")) q.put("hourly", args.get("hourly"));
            if ("query".equals("query") && args != null && args.containsKey("minutely")) q.put("minutely", args.get("minutely"));
            if ("query".equals("query") && args != null && args.containsKey("indices")) q.put("indices", args.get("indices"));
            if ("query".equals("query") && args != null && args.containsKey("lang")) q.put("lang", args.get("lang"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/weather";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getMiscWorldtime(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("city")) q.put("city", args.get("city"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/misc/worldtime";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postMiscDateDiff(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("end_date")) body.put("end_date", args.get("end_date"));
            if (args != null && args.containsKey("format")) body.put("format", args.get("format"));
            if (args != null && args.containsKey("start_date")) body.put("start_date", args.get("start_date"));
            String path = "/api/v1/misc/date-diff";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public NetworkApi network() { return new NetworkApi(); }
    public class NetworkApi {
        public Object getNetworkDns(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/dns";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkIcp(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/icp";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkIpinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("ip")) q.put("ip", args.get("ip"));
            if ("query".equals("query") && args != null && args.containsKey("source")) q.put("source", args.get("source"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/ipinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkMyip(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("source")) q.put("source", args.get("source"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/myip";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkPing(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("host")) q.put("host", args.get("host"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/ping";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkPingmyip(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/pingmyip";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkPortscan(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("host")) q.put("host", args.get("host"));
            if ("query".equals("query") && args != null && args.containsKey("port")) q.put("port", args.get("port"));
            if ("query".equals("query") && args != null && args.containsKey("protocol")) q.put("protocol", args.get("protocol"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/portscan";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkUrlstatus(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/urlstatus";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkWhois(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/whois";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getNetworkWxdomain(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/network/wxdomain";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public PoemApi poem() { return new PoemApi(); }
    public class PoemApi {
        public Object getSaying(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/saying";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public RandomApi random() { return new RandomApi(); }
    public class RandomApi {
        public Object getAnswerbookAsk(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("question")) q.put("question", args.get("question"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/answerbook/ask";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getRandomImage(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("category")) q.put("category", args.get("category"));
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/random/image";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getRandomString(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("length")) q.put("length", args.get("length"));
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/random/string";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postAnswerbookAsk(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("question")) body.put("question", args.get("question"));
            String path = "/api/v1/answerbook/ask";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public SocialApi social() { return new SocialApi(); }
    public class SocialApi {
        public Object getGithubRepo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("repo")) q.put("repo", args.get("repo"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/github/repo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getGithubUser(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("user")) q.put("user", args.get("user"));
            if ("query".equals("query") && args != null && args.containsKey("activity")) q.put("activity", args.get("activity"));
            if ("query".equals("query") && args != null && args.containsKey("activity_scope")) q.put("activity_scope", args.get("activity_scope"));
            if ("query".equals("query") && args != null && args.containsKey("org")) q.put("org", args.get("org"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/github/user";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialBilibiliArchives(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("mid")) q.put("mid", args.get("mid"));
            if ("query".equals("query") && args != null && args.containsKey("keywords")) q.put("keywords", args.get("keywords"));
            if ("query".equals("query") && args != null && args.containsKey("orderby")) q.put("orderby", args.get("orderby"));
            if ("query".equals("query") && args != null && args.containsKey("ps")) q.put("ps", args.get("ps"));
            if ("query".equals("query") && args != null && args.containsKey("pn")) q.put("pn", args.get("pn"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/bilibili/archives";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialBilibiliLiveroom(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("mid")) q.put("mid", args.get("mid"));
            if ("query".equals("query") && args != null && args.containsKey("room_id")) q.put("room_id", args.get("room_id"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/bilibili/liveroom";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialBilibiliReplies(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("oid")) q.put("oid", args.get("oid"));
            if ("query".equals("query") && args != null && args.containsKey("sort")) q.put("sort", args.get("sort"));
            if ("query".equals("query") && args != null && args.containsKey("ps")) q.put("ps", args.get("ps"));
            if ("query".equals("query") && args != null && args.containsKey("pn")) q.put("pn", args.get("pn"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/bilibili/replies";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialBilibiliUserinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("uid")) q.put("uid", args.get("uid"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/bilibili/userinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialBilibiliVideoinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("aid")) q.put("aid", args.get("aid"));
            if ("query".equals("query") && args != null && args.containsKey("bvid")) q.put("bvid", args.get("bvid"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/bilibili/videoinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialQqGroupinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("group_id")) q.put("group_id", args.get("group_id"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/qq/groupinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getSocialQqUserinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("qq")) q.put("qq", args.get("qq"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/social/qq/userinfo";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public StatusApi status() { return new StatusApi(); }
    public class StatusApi {
        public Object getStatusRatelimit(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("header".equals("query") && args != null && args.containsKey("Authorization")) q.put("Authorization", args.get("Authorization"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/status/ratelimit";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getStatusUsage(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("path")) q.put("path", args.get("path"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/status/usage";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public TextApi text() { return new TextApi(); }
    public class TextApi {
        public Object getTextMd5(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("text")) q.put("text", args.get("text"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/text/md5";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextAesDecrypt(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("key")) body.put("key", args.get("key"));
            if (args != null && args.containsKey("nonce")) body.put("nonce", args.get("nonce"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/aes/decrypt";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextAesDecryptAdvanced(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("iv")) body.put("iv", args.get("iv"));
            if (args != null && args.containsKey("key")) body.put("key", args.get("key"));
            if (args != null && args.containsKey("mode")) body.put("mode", args.get("mode"));
            if (args != null && args.containsKey("padding")) body.put("padding", args.get("padding"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/aes/decrypt-advanced";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextAesEncrypt(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("key")) body.put("key", args.get("key"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/aes/encrypt";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextAesEncryptAdvanced(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("iv")) body.put("iv", args.get("iv"));
            if (args != null && args.containsKey("key")) body.put("key", args.get("key"));
            if (args != null && args.containsKey("mode")) body.put("mode", args.get("mode"));
            if (args != null && args.containsKey("output_format")) body.put("output_format", args.get("output_format"));
            if (args != null && args.containsKey("padding")) body.put("padding", args.get("padding"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/aes/encrypt-advanced";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextAnalyze(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/analyze";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextBase64Decode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/base64/decode";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextBase64Encode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/base64/encode";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextConvert(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("from")) body.put("from", args.get("from"));
            if (args != null && args.containsKey("options")) body.put("options", args.get("options"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            if (args != null && args.containsKey("to")) body.put("to", args.get("to"));
            String path = "/api/v1/text/convert";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextMarkdownToHtml(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("format")) body.put("format", args.get("format"));
            if (args != null && args.containsKey("sanitize")) body.put("sanitize", args.get("sanitize"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/markdown-to-html";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextMarkdownToPdf(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("paper_size")) body.put("paper_size", args.get("paper_size"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            if (args != null && args.containsKey("theme")) body.put("theme", args.get("theme"));
            String path = "/api/v1/text/markdown-to-pdf";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextMd5(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/md5";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTextMd5Verify(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("hash")) body.put("hash", args.get("hash"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/md5/verify";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public TranslateApi translate() { return new TranslateApi(); }
    public class TranslateApi {
        public Object getAiTranslateLanguages(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/ai/translate/languages";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postAiTranslate(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("target_lang")) q.put("target_lang", args.get("target_lang"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("context")) body.put("context", args.get("context"));
            if (args != null && args.containsKey("preserve_format")) body.put("preserve_format", args.get("preserve_format"));
            if (args != null && args.containsKey("source_lang")) body.put("source_lang", args.get("source_lang"));
            if (args != null && args.containsKey("style")) body.put("style", args.get("style"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/ai/translate";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTranslateStream(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("from_lang")) body.put("from_lang", args.get("from_lang"));
            if (args != null && args.containsKey("query")) body.put("query", args.get("query"));
            if (args != null && args.containsKey("to_lang")) body.put("to_lang", args.get("to_lang"));
            if (args != null && args.containsKey("tone")) body.put("tone", args.get("tone"));
            String path = "/api/v1/translate/stream";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postTranslateText(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("to_lang")) q.put("to_lang", args.get("to_lang"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/translate/text";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public WebparseApi webparse() { return new WebparseApi(); }
    public class WebparseApi {
        public Object getWebTomarkdownAsyncStatus(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("path".equals("query") && args != null && args.containsKey("task_id")) q.put("task_id", args.get("task_id"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/web/tomarkdown/async/{task_id}";
            if (args != null && args.containsKey("task_id")) path = path.replace("{" + "task_id" + "}", String.valueOf(args.get("task_id")));
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getWebparseExtractimages(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/webparse/extractimages";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object getWebparseMetadata(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/webparse/metadata";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postWebTomarkdownAsync(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/web/tomarkdown/async";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public MinGanCiShiBieApi minGanCiShiBie() { return new MinGanCiShiBieApi(); }
    public class MinGanCiShiBieApi {
        public Object getSensitiveWordAnalyzeQuery(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if ("query".equals("query") && args != null && args.containsKey("keyword")) q.put("keyword", args.get("keyword"));
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/sensitive-word/analyze-query";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postSensitiveWordAnalyze(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("keywords")) body.put("keywords", args.get("keywords"));
            String path = "/api/v1/sensitive-word/analyze";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postSensitiveWordQuickCheck(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("text")) body.put("text", args.get("text"));
            String path = "/api/v1/text/profanitycheck";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
    public ZhiNengSouSuoApi zhiNengSouSuo() { return new ZhiNengSouSuoApi(); }
    public class ZhiNengSouSuoApi {
        public Object getSearchEngines(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            String path = "/api/v1/search/engines";
            return request("GET", path, q, body.isEmpty() ? null : body, disableCache);
        }
        public Object postSearchAggregate(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            Map<String, Object> body = new HashMap<>();
            Boolean disableCache = readDisableCache(args);
            if (args != null && args.containsKey("_t")) q.put("_t", args.get("_t"));
            if (args != null && args.containsKey("fetch_full")) body.put("fetch_full", args.get("fetch_full"));
            if (args != null && args.containsKey("filetype")) body.put("filetype", args.get("filetype"));
            if (args != null && args.containsKey("query")) body.put("query", args.get("query"));
            if (args != null && args.containsKey("site")) body.put("site", args.get("site"));
            if (args != null && args.containsKey("sort")) body.put("sort", args.get("sort"));
            if (args != null && args.containsKey("time_range")) body.put("time_range", args.get("time_range"));
            String path = "/api/v1/search/aggregate";
            return request("POST", path, q, body.isEmpty() ? null : body, disableCache);
        }
    }
}
