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

    public Client(String baseUrl, String token) { this.baseUrl = baseUrl; this.token = token; }

    private Object request(String method, String path, Map<String, Object> params, Object body) throws UapiException, IOException {
        HttpUrl.Builder url = HttpUrl.parse(baseUrl + path).newBuilder();
        if (params != null) for (var e: params.entrySet()) url.addQueryParameter(e.getKey(), String.valueOf(e.getValue()));
        RequestBody reqBody = body == null ? null : RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(body));
        Request.Builder req = new Request.Builder().url(url.build());
        req.method(method, reqBody);
        if (token != null && !token.isEmpty()) req.addHeader("Authorization", "Bearer " + token);
        Response resp = http.newCall(req.build()).execute();
        String ct = resp.header("content-type", "");
        String text = resp.body() == null ? "" : resp.body().string();
        if (!resp.isSuccessful()) throw UapiException.map(resp.code(), text);
        if (ct.contains("application/json")) return new Gson().fromJson(text, Object.class);
        return text;
    }
    public ClipzyZaiXianJianTieBanApi clipzyZaiXianJianTieBan() { return new ClipzyZaiXianJianTieBanApi(); }
    public class ClipzyZaiXianJianTieBanApi {
        public Object getClipzyGet(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("id")) q.put("id", args.get("id"));
            String path = "/api/v1/api/get";
            return request("GET", path, q, null);
        }
        public Object getClipzyRaw(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("path".equals("query") && args != null && args.containsKey("id")) q.put("id", args.get("id"));
            if ("query".equals("query") && args != null && args.containsKey("key")) q.put("key", args.get("key"));
            String path = "/api/v1/api/raw/{id}";
            if (args != null && args.containsKey("id")) path = path.replace("{" + "id" + "}", String.valueOf(args.get("id")));
            return request("GET", path, q, null);
        }
        public Object postClipzyStore(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/api/store";
            return request("POST", path, q, null);
        }
    }
    public ConvertApi convert() { return new ConvertApi(); }
    public class ConvertApi {
        public Object getConvertUnixtime(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("time")) q.put("time", args.get("time"));
            String path = "/api/v1/convert/unixtime";
            return request("GET", path, q, null);
        }
        public Object postConvertJson(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/convert/json";
            return request("POST", path, q, null);
        }
    }
    public DailyApi daily() { return new DailyApi(); }
    public class DailyApi {
        public Object getDailyNewsImage(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/daily/news-image";
            return request("GET", path, q, null);
        }
    }
    public GameApi game() { return new GameApi(); }
    public class GameApi {
        public Object getGameEpicFree(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/game/epic-free";
            return request("GET", path, q, null);
        }
        public Object getGameMinecraftHistoryid(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("uuid")) q.put("uuid", args.get("uuid"));
            String path = "/api/v1/game/minecraft/historyid";
            return request("GET", path, q, null);
        }
        public Object getGameMinecraftServerstatus(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("server")) q.put("server", args.get("server"));
            String path = "/api/v1/game/minecraft/serverstatus";
            return request("GET", path, q, null);
        }
        public Object getGameMinecraftUserinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("username")) q.put("username", args.get("username"));
            String path = "/api/v1/game/minecraft/userinfo";
            return request("GET", path, q, null);
        }
        public Object getGameSteamSummary(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("steamid")) q.put("steamid", args.get("steamid"));
            if ("query".equals("query") && args != null && args.containsKey("id")) q.put("id", args.get("id"));
            if ("query".equals("query") && args != null && args.containsKey("id3")) q.put("id3", args.get("id3"));
            if ("query".equals("query") && args != null && args.containsKey("key")) q.put("key", args.get("key"));
            String path = "/api/v1/game/steam/summary";
            return request("GET", path, q, null);
        }
    }
    public ImageApi image() { return new ImageApi(); }
    public class ImageApi {
        public Object getAvatarGravatar(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("email")) q.put("email", args.get("email"));
            if ("query".equals("query") && args != null && args.containsKey("hash")) q.put("hash", args.get("hash"));
            if ("query".equals("query") && args != null && args.containsKey("s")) q.put("s", args.get("s"));
            if ("query".equals("query") && args != null && args.containsKey("d")) q.put("d", args.get("d"));
            if ("query".equals("query") && args != null && args.containsKey("r")) q.put("r", args.get("r"));
            String path = "/api/v1/avatar/gravatar";
            return request("GET", path, q, null);
        }
        public Object getImageBingDaily(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/image/bing-daily";
            return request("GET", path, q, null);
        }
        public Object getImageMotou(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("qq")) q.put("qq", args.get("qq"));
            if ("query".equals("query") && args != null && args.containsKey("bg_color")) q.put("bg_color", args.get("bg_color"));
            String path = "/api/v1/image/motou";
            return request("GET", path, q, null);
        }
        public Object getImageQrcode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("text")) q.put("text", args.get("text"));
            if ("query".equals("query") && args != null && args.containsKey("size")) q.put("size", args.get("size"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            String path = "/api/v1/image/qrcode";
            return request("GET", path, q, null);
        }
        public Object getImageTobase64(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            String path = "/api/v1/image/tobase64";
            return request("GET", path, q, null);
        }
        public Object postImageCompress(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("level")) q.put("level", args.get("level"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            String path = "/api/v1/image/compress";
            return request("POST", path, q, null);
        }
        public Object postImageFrombase64(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/image/frombase64";
            return request("POST", path, q, null);
        }
        public Object postImageMotou(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/image/motou";
            return request("POST", path, q, null);
        }
        public Object postImageSpeechless(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/image/speechless";
            return request("POST", path, q, null);
        }
        public Object postImageSvg(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            if ("query".equals("query") && args != null && args.containsKey("width")) q.put("width", args.get("width"));
            if ("query".equals("query") && args != null && args.containsKey("height")) q.put("height", args.get("height"));
            if ("query".equals("query") && args != null && args.containsKey("quality")) q.put("quality", args.get("quality"));
            String path = "/api/v1/image/svg";
            return request("POST", path, q, null);
        }
    }
    public MiscApi misc() { return new MiscApi(); }
    public class MiscApi {
        public Object getHistoryProgrammer(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("month")) q.put("month", args.get("month"));
            if ("query".equals("query") && args != null && args.containsKey("day")) q.put("day", args.get("day"));
            String path = "/api/v1/history/programmer";
            return request("GET", path, q, null);
        }
        public Object getHistoryProgrammerToday(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/history/programmer/today";
            return request("GET", path, q, null);
        }
        public Object getMiscHotboard(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            String path = "/api/v1/misc/hotboard";
            return request("GET", path, q, null);
        }
        public Object getMiscPhoneinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("phone")) q.put("phone", args.get("phone"));
            String path = "/api/v1/misc/phoneinfo";
            return request("GET", path, q, null);
        }
        public Object getMiscRandomnumber(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("min")) q.put("min", args.get("min"));
            if ("query".equals("query") && args != null && args.containsKey("max")) q.put("max", args.get("max"));
            if ("query".equals("query") && args != null && args.containsKey("count")) q.put("count", args.get("count"));
            if ("query".equals("query") && args != null && args.containsKey("allow_repeat")) q.put("allow_repeat", args.get("allow_repeat"));
            if ("query".equals("query") && args != null && args.containsKey("allow_decimal")) q.put("allow_decimal", args.get("allow_decimal"));
            if ("query".equals("query") && args != null && args.containsKey("decimal_places")) q.put("decimal_places", args.get("decimal_places"));
            String path = "/api/v1/misc/randomnumber";
            return request("GET", path, q, null);
        }
        public Object getMiscTimestamp(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("ts")) q.put("ts", args.get("ts"));
            String path = "/api/v1/misc/timestamp";
            return request("GET", path, q, null);
        }
        public Object getMiscTrackingCarriers(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/misc/tracking/carriers";
            return request("GET", path, q, null);
        }
        public Object getMiscTrackingDetect(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("tracking_number")) q.put("tracking_number", args.get("tracking_number"));
            String path = "/api/v1/misc/tracking/detect";
            return request("GET", path, q, null);
        }
        public Object getMiscTrackingQuery(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("tracking_number")) q.put("tracking_number", args.get("tracking_number"));
            if ("query".equals("query") && args != null && args.containsKey("carrier_code")) q.put("carrier_code", args.get("carrier_code"));
            String path = "/api/v1/misc/tracking/query";
            return request("GET", path, q, null);
        }
        public Object getMiscWeather(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("city")) q.put("city", args.get("city"));
            if ("query".equals("query") && args != null && args.containsKey("adcode")) q.put("adcode", args.get("adcode"));
            String path = "/api/v1/misc/weather";
            return request("GET", path, q, null);
        }
        public Object getMiscWorldtime(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("city")) q.put("city", args.get("city"));
            String path = "/api/v1/misc/worldtime";
            return request("GET", path, q, null);
        }
    }
    public NetworkApi network() { return new NetworkApi(); }
    public class NetworkApi {
        public Object getNetworkDns(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            String path = "/api/v1/network/dns";
            return request("GET", path, q, null);
        }
        public Object getNetworkIcp(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            String path = "/api/v1/network/icp";
            return request("GET", path, q, null);
        }
        public Object getNetworkIpinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("ip")) q.put("ip", args.get("ip"));
            if ("query".equals("query") && args != null && args.containsKey("source")) q.put("source", args.get("source"));
            String path = "/api/v1/network/ipinfo";
            return request("GET", path, q, null);
        }
        public Object getNetworkMyip(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("source")) q.put("source", args.get("source"));
            String path = "/api/v1/network/myip";
            return request("GET", path, q, null);
        }
        public Object getNetworkPing(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("host")) q.put("host", args.get("host"));
            String path = "/api/v1/network/ping";
            return request("GET", path, q, null);
        }
        public Object getNetworkPingmyip(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/network/pingmyip";
            return request("GET", path, q, null);
        }
        public Object getNetworkPortscan(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("host")) q.put("host", args.get("host"));
            if ("query".equals("query") && args != null && args.containsKey("port")) q.put("port", args.get("port"));
            if ("query".equals("query") && args != null && args.containsKey("protocol")) q.put("protocol", args.get("protocol"));
            String path = "/api/v1/network/portscan";
            return request("GET", path, q, null);
        }
        public Object getNetworkUrlstatus(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            String path = "/api/v1/network/urlstatus";
            return request("GET", path, q, null);
        }
        public Object getNetworkWhois(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            if ("query".equals("query") && args != null && args.containsKey("format")) q.put("format", args.get("format"));
            String path = "/api/v1/network/whois";
            return request("GET", path, q, null);
        }
        public Object getNetworkWxdomain(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("domain")) q.put("domain", args.get("domain"));
            String path = "/api/v1/network/wxdomain";
            return request("GET", path, q, null);
        }
    }
    public PoemApi poem() { return new PoemApi(); }
    public class PoemApi {
        public Object getSaying(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/saying";
            return request("GET", path, q, null);
        }
    }
    public RandomApi random() { return new RandomApi(); }
    public class RandomApi {
        public Object getAnswerbookAsk(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("question")) q.put("question", args.get("question"));
            String path = "/api/v1/answerbook/ask";
            return request("GET", path, q, null);
        }
        public Object getRandomImage(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("category")) q.put("category", args.get("category"));
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            String path = "/api/v1/random/image";
            return request("GET", path, q, null);
        }
        public Object getRandomString(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("length")) q.put("length", args.get("length"));
            if ("query".equals("query") && args != null && args.containsKey("type")) q.put("type", args.get("type"));
            String path = "/api/v1/random/string";
            return request("GET", path, q, null);
        }
        public Object postAnswerbookAsk(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/answerbook/ask";
            return request("POST", path, q, null);
        }
    }
    public SocialApi social() { return new SocialApi(); }
    public class SocialApi {
        public Object getGithubRepo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("repo")) q.put("repo", args.get("repo"));
            String path = "/api/v1/github/repo";
            return request("GET", path, q, null);
        }
        public Object getSocialBilibiliArchives(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("mid")) q.put("mid", args.get("mid"));
            if ("query".equals("query") && args != null && args.containsKey("keywords")) q.put("keywords", args.get("keywords"));
            if ("query".equals("query") && args != null && args.containsKey("orderby")) q.put("orderby", args.get("orderby"));
            if ("query".equals("query") && args != null && args.containsKey("ps")) q.put("ps", args.get("ps"));
            if ("query".equals("query") && args != null && args.containsKey("pn")) q.put("pn", args.get("pn"));
            String path = "/api/v1/social/bilibili/archives";
            return request("GET", path, q, null);
        }
        public Object getSocialBilibiliLiveroom(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("mid")) q.put("mid", args.get("mid"));
            if ("query".equals("query") && args != null && args.containsKey("room_id")) q.put("room_id", args.get("room_id"));
            String path = "/api/v1/social/bilibili/liveroom";
            return request("GET", path, q, null);
        }
        public Object getSocialBilibiliReplies(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("oid")) q.put("oid", args.get("oid"));
            if ("query".equals("query") && args != null && args.containsKey("sort")) q.put("sort", args.get("sort"));
            if ("query".equals("query") && args != null && args.containsKey("ps")) q.put("ps", args.get("ps"));
            if ("query".equals("query") && args != null && args.containsKey("pn")) q.put("pn", args.get("pn"));
            String path = "/api/v1/social/bilibili/replies";
            return request("GET", path, q, null);
        }
        public Object getSocialBilibiliUserinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("uid")) q.put("uid", args.get("uid"));
            String path = "/api/v1/social/bilibili/userinfo";
            return request("GET", path, q, null);
        }
        public Object getSocialBilibiliVideoinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("aid")) q.put("aid", args.get("aid"));
            if ("query".equals("query") && args != null && args.containsKey("bvid")) q.put("bvid", args.get("bvid"));
            String path = "/api/v1/social/bilibili/videoinfo";
            return request("GET", path, q, null);
        }
        public Object getSocialQqGroupinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("group_id")) q.put("group_id", args.get("group_id"));
            String path = "/api/v1/social/qq/groupinfo";
            return request("GET", path, q, null);
        }
        public Object getSocialQqUserinfo(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("qq")) q.put("qq", args.get("qq"));
            String path = "/api/v1/social/qq/userinfo";
            return request("GET", path, q, null);
        }
    }
    public StatusApi status() { return new StatusApi(); }
    public class StatusApi {
        public Object getStatusRatelimit(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("header".equals("query") && args != null && args.containsKey("Authorization")) q.put("Authorization", args.get("Authorization"));
            String path = "/api/v1/status/ratelimit";
            return request("GET", path, q, null);
        }
        public Object getStatusUsage(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("path")) q.put("path", args.get("path"));
            String path = "/api/v1/status/usage";
            return request("GET", path, q, null);
        }
    }
    public TextApi text() { return new TextApi(); }
    public class TextApi {
        public Object getTextMd5(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("text")) q.put("text", args.get("text"));
            String path = "/api/v1/text/md5";
            return request("GET", path, q, null);
        }
        public Object postTextAesDecrypt(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/aes/decrypt";
            return request("POST", path, q, null);
        }
        public Object postTextAesEncrypt(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/aes/encrypt";
            return request("POST", path, q, null);
        }
        public Object postTextAnalyze(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/analyze";
            return request("POST", path, q, null);
        }
        public Object postTextBase64Decode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/base64/decode";
            return request("POST", path, q, null);
        }
        public Object postTextBase64Encode(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/base64/encode";
            return request("POST", path, q, null);
        }
        public Object postTextMd5(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/md5";
            return request("POST", path, q, null);
        }
        public Object postTextMd5Verify(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/md5/verify";
            return request("POST", path, q, null);
        }
    }
    public TranslateApi translate() { return new TranslateApi(); }
    public class TranslateApi {
        public Object getAiTranslateLanguages(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/ai/translate/languages";
            return request("GET", path, q, null);
        }
        public Object postAiTranslate(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("target_lang")) q.put("target_lang", args.get("target_lang"));
            String path = "/api/v1/ai/translate";
            return request("POST", path, q, null);
        }
        public Object postTranslateStream(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/translate/stream";
            return request("POST", path, q, null);
        }
        public Object postTranslateText(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("to_lang")) q.put("to_lang", args.get("to_lang"));
            String path = "/api/v1/translate/text";
            return request("POST", path, q, null);
        }
    }
    public WebparseApi webparse() { return new WebparseApi(); }
    public class WebparseApi {
        public Object getWebTomarkdownAsyncStatus(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("path".equals("query") && args != null && args.containsKey("task_id")) q.put("task_id", args.get("task_id"));
            String path = "/api/v1/web/tomarkdown/async/{task_id}";
            if (args != null && args.containsKey("task_id")) path = path.replace("{" + "task_id" + "}", String.valueOf(args.get("task_id")));
            return request("GET", path, q, null);
        }
        public Object getWebparseExtractimages(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            String path = "/api/v1/webparse/extractimages";
            return request("GET", path, q, null);
        }
        public Object getWebparseMetadata(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            String path = "/api/v1/webparse/metadata";
            return request("GET", path, q, null);
        }
        public Object postWebTomarkdownAsync(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("url")) q.put("url", args.get("url"));
            String path = "/api/v1/web/tomarkdown/async";
            return request("POST", path, q, null);
        }
    }
    public MinGanCiShiBieApi minGanCiShiBie() { return new MinGanCiShiBieApi(); }
    public class MinGanCiShiBieApi {
        public Object getSensitiveWordAnalyzeQuery(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            if ("query".equals("query") && args != null && args.containsKey("keyword")) q.put("keyword", args.get("keyword"));
            String path = "/api/v1/sensitive-word/analyze-query";
            return request("GET", path, q, null);
        }
        public Object postSensitiveWordAnalyze(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/sensitive-word/analyze";
            return request("POST", path, q, null);
        }
        public Object postSensitiveWordQuickCheck(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/text/profanitycheck";
            return request("POST", path, q, null);
        }
    }
    public ZhiNengSouSuoApi zhiNengSouSuo() { return new ZhiNengSouSuoApi(); }
    public class ZhiNengSouSuoApi {
        public Object getSearchEngines(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/search/engines";
            return request("GET", path, q, null);
        }
        public Object postSearchAggregate(Map<String, Object> args) throws Exception {
            Map<String, Object> q = new HashMap<>();
            String path = "/api/v1/search/aggregate";
            return request("POST", path, q, null);
        }
    }
}
