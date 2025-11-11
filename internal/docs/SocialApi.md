# SocialApi

All URIs are relative to *https://uapis.cn/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getGithubRepo**](SocialApi.md#getGithubRepo) | **GET** /github/repo | 获取GitHub仓库信息 |
| [**getSocialBilibiliArchives**](SocialApi.md#getSocialBilibiliArchives) | **GET** /social/bilibili/archives | 获取Bilibili用户投稿列表 |
| [**getSocialBilibiliLiveroom**](SocialApi.md#getSocialBilibiliLiveroom) | **GET** /social/bilibili/liveroom | 获取Bilibili直播间信息 |
| [**getSocialBilibiliReplies**](SocialApi.md#getSocialBilibiliReplies) | **GET** /social/bilibili/replies | 获取Bilibili视频评论 |
| [**getSocialBilibiliUserinfo**](SocialApi.md#getSocialBilibiliUserinfo) | **GET** /social/bilibili/userinfo | 查询Bilibili用户信息 |
| [**getSocialBilibiliVideoinfo**](SocialApi.md#getSocialBilibiliVideoinfo) | **GET** /social/bilibili/videoinfo | 获取Bilibili视频详细信息 |
| [**getSocialQqGroupinfo**](SocialApi.md#getSocialQqGroupinfo) | **GET** /social/qq/groupinfo | 获取QQ群名称、头像、简介 |
| [**getSocialQqUserinfo**](SocialApi.md#getSocialQqUserinfo) | **GET** /social/qq/userinfo | 独家获取QQ号头像、昵称 |


<a id="getGithubRepo"></a>
# **getGithubRepo**
> GetGithubRepo200Response getGithubRepo(repo)

获取GitHub仓库信息

需要快速获取一个GitHub仓库的核心信息？这个接口为你聚合了最有价值的数据，避免了多次调用GitHub官方API的麻烦，并且内置了缓存优化，速度更快、更稳定。  ### 聚合高价值数据 一次请求，即可获得以下信息： - **核心指标**: &#x60;star&#x60;, &#x60;fork&#x60;, &#x60;open_issues&#x60; 等关键统计数据。 - **项目详情**: 描述、主页、分支、语言、话题标签、开源协议。 - **参与者信息**: 获取协作者(&#x60;collaborators&#x60;)和推断的维护者(&#x60;maintainers&#x60;)列表，包括他们的公开邮箱（如果可用）。  &gt; [!NOTE] &gt; &#x60;collaborators&#x60; 字段在私有仓库或权限受限时可能为空。&#x60;maintainers&#x60; 是根据最新提交记录推断的，仅供参考。  ### 性能与稳定性 我们内置了多级缓存，有效避免触发GitHub的API速率限制。对于需要更高请求额度的用户，可以联系我们定制接口。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String repo = "torvalds/linux"; // String | 目标仓库的标识，格式为 `owner/repo`。
    try {
      GetGithubRepo200Response result = apiInstance.getGithubRepo(repo);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getGithubRepo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **repo** | **String**| 目标仓库的标识，格式为 &#x60;owner/repo&#x60;。 | |

### Return type

[**GetGithubRepo200Response**](GetGithubRepo200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取仓库信息。 |  -  |
| **400** | 请求参数缺失或格式错误。请确保 &#x60;repo&#x60; 参数已提供且格式为 &#x60;owner/repo&#x60;。 |  -  |
| **502** | 上游 GitHub API 出错或不可用。响应中会包含来自上游的原始错误信息，便于排查问题。 |  -  |

<a id="getSocialBilibiliArchives"></a>
# **getSocialBilibiliArchives**
> GetSocialBilibiliArchives200Response getSocialBilibiliArchives(mid, keywords, orderby, ps, pn)

获取Bilibili用户投稿列表

想要获取UP主的所有投稿视频？或者想在你的应用里展示创作者的作品集？这个接口能帮你轻松实现。  ## 功能概述 通过用户的 &#x60;mid&#x60;（用户ID），你可以获取该UP主的投稿视频列表。接口支持关键词搜索、分页加载和多种排序方式，让你能够灵活地展示和分析创作者的内容。  ## 参数说明 - **&#x60;mid&#x60; (用户ID)**: B站用户的mid，必填参数。 - **&#x60;keywords&#x60; (搜索关键词)**: 可选，用于在该UP主的投稿中搜索特定关键词。 - **&#x60;orderby&#x60; (排序方式)**:    - &#x60;pubdate&#x60;: 按最新发布排序（默认）   - &#x60;views&#x60;: 按最多播放排序 - **&#x60;ps&#x60; (每页条数)**: 默认20条。 - **&#x60;pn&#x60; (页码)**: 默认1，用于分页。  ## 响应体字段说明 - **&#x60;total&#x60; (总稿件数)**: UP主的投稿总数。 - **&#x60;page&#x60; (当前页码)**: 当前返回的页码。 - **&#x60;size&#x60; (每页数量)**: 每页返回的视频数量。 - **&#x60;videos&#x60; (视频列表)**: 包含当前页的所有视频信息：   - &#x60;aid&#x60;: 视频的AV号   - &#x60;bvid&#x60;: 视频的BV号   - &#x60;title&#x60;: 视频标题   - &#x60;cover&#x60;: 封面URL   - &#x60;duration&#x60;: 时长（秒）   - &#x60;play_count&#x60;: 播放量   - &#x60;publish_time&#x60;: 发布时间戳   - &#x60;create_time&#x60;: 创建时间戳   - &#x60;state&#x60;: 视频状态   - &#x60;is_ugc_pay&#x60;: 是否付费视频（0&#x3D;免费，1&#x3D;付费）   - &#x60;is_interactive&#x60;: 是否为互动视频

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String mid = "483307278"; // String | B站用户的mid（用户ID）
    String keywords = "keywords_example"; // String | 搜索关键词，可为空
    String orderby = "pubdate"; // String | 排序方式。`pubdate`=最新发布，`views`=最多播放
    String ps = "20"; // String | 每页条数，默认20
    String pn = "1"; // String | 页码，默认1
    try {
      GetSocialBilibiliArchives200Response result = apiInstance.getSocialBilibiliArchives(mid, keywords, orderby, ps, pn);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialBilibiliArchives");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **mid** | **String**| B站用户的mid（用户ID） | |
| **keywords** | **String**| 搜索关键词，可为空 | [optional] |
| **orderby** | **String**| 排序方式。&#x60;pubdate&#x60;&#x3D;最新发布，&#x60;views&#x60;&#x3D;最多播放 | [optional] |
| **ps** | **String**| 每页条数，默认20 | [optional] |
| **pn** | **String**| 页码，默认1 | [optional] |

### Return type

[**GetSocialBilibiliArchives200Response**](GetSocialBilibiliArchives200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功！返回用户的投稿视频列表。 |  -  |
| **400** | 参数错误 |  -  |
| **404** | 用户不存在 |  -  |
| **500** | 服务器错误 |  -  |

<a id="getSocialBilibiliLiveroom"></a>
# **getSocialBilibiliLiveroom**
> GetSocialBilibiliLiveroom200Response getSocialBilibiliLiveroom(mid, roomId)

获取Bilibili直播间信息

想知道你喜欢的主播开播了吗？或者想在你的应用里集成B站直播间状态？这个接口能满足你。  ## 功能概述 这是一个智能接口，你可以用主播的 &#x60;mid&#x60; (用户ID) 或者直播间的 &#x60;room_id&#x60; (长号或短号)来查询。它会返回直播间的详细信息，包括是否在直播、标题、封面、人气、分区等。  ## 响应体字段说明 - **&#x60;live_status&#x60; (直播状态)**: &#x60;0&#x60; 代表未开播，&#x60;1&#x60; 代表直播中，&#x60;2&#x60; 代表轮播中。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String mid = "672328094"; // String | 主播的用户ID (`mid`)。与 `room_id` 任选其一。
    String roomId = "22637261"; // String | 直播间ID，可以是长号（真实ID）或短号（靓号）。与 `mid` 任选其一。
    try {
      GetSocialBilibiliLiveroom200Response result = apiInstance.getSocialBilibiliLiveroom(mid, roomId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialBilibiliLiveroom");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **mid** | **String**| 主播的用户ID (&#x60;mid&#x60;)。与 &#x60;room_id&#x60; 任选其一。 | [optional] |
| **roomId** | **String**| 直播间ID，可以是长号（真实ID）或短号（靓号）。与 &#x60;mid&#x60; 任选其一。 | [optional] |

### Return type

[**GetSocialBilibiliLiveroom200Response**](GetSocialBilibiliLiveroom200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功！返回直播间的详细信息。 |  -  |

<a id="getSocialBilibiliReplies"></a>
# **getSocialBilibiliReplies**
> GetSocialBilibiliReplies200Response getSocialBilibiliReplies(oid, sort, ps, pn)

获取Bilibili视频评论

想要分析B站视频的评论区？这个接口可以帮你轻松获取评论数据，包括热门评论和最新评论，还支持分页加载。  ## 功能概述 通过视频的 &#x60;oid&#x60;（通常就是视频的&#x60;aid&#x60;），你可以分页获取该视频的评论区内容。你可以指定排序方式和分页参数，来精确地获取你需要的数据。  ## 参数说明 - **&#x60;sort&#x60; (排序方式)**: &#x60;0&#x60;&#x3D;按时间排序, &#x60;1&#x60;&#x3D;按点赞数排序, &#x60;2&#x60;&#x3D;按回复数排序。默认为按时间排序。  ## 响应体字段说明 - **&#x60;hots&#x60; (热门评论)**: 仅在请求第一页时，可能会返回热门评论列表。其结构与 &#x60;replies&#x60; 中的对象一致。 - **&#x60;replies&#x60; (评论列表)**: 这是一个数组，包含了当前页的评论。其中：   - &#x60;root&#x60;: 指向根评论的ID。如果评论本身就是根评论，则为 &#x60;0&#x60;。   - &#x60;parent&#x60;: 指向该条回复所回复的上一级评论ID。如果评论是根评论，则为 &#x60;0&#x60;。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String oid = "1706416465"; // String | 目标评论区的ID。对于视频，这通常就是它的 `aid`。
    String sort = "1"; // String | 排序方式。`0`=按时间, `1`=按点赞, `2`=按回复。默认为 `0`。
    String ps = "5"; // String | 每页获取的评论数量，范围是1到20。默认为 `20`。
    String pn = "1"; // String | 要获取的页码，从1开始。默认为 `1`。
    try {
      GetSocialBilibiliReplies200Response result = apiInstance.getSocialBilibiliReplies(oid, sort, ps, pn);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialBilibiliReplies");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **oid** | **String**| 目标评论区的ID。对于视频，这通常就是它的 &#x60;aid&#x60;。 | |
| **sort** | **String**| 排序方式。&#x60;0&#x60;&#x3D;按时间, &#x60;1&#x60;&#x3D;按点赞, &#x60;2&#x60;&#x3D;按回复。默认为 &#x60;0&#x60;。 | [optional] |
| **ps** | **String**| 每页获取的评论数量，范围是1到20。默认为 &#x60;20&#x60;。 | [optional] |
| **pn** | **String**| 要获取的页码，从1开始。默认为 &#x60;1&#x60;。 | [optional] |

### Return type

[**GetSocialBilibiliReplies200Response**](GetSocialBilibiliReplies200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功！返回指定分页和排序的评论列表。 |  -  |

<a id="getSocialBilibiliUserinfo"></a>
# **getSocialBilibiliUserinfo**
> GetSocialBilibiliUserinfo200Response getSocialBilibiliUserinfo(uid)

查询Bilibili用户信息

想在你的应用里集成B站用户资料展示？这个接口可以轻松获取用户的公开信息。  ## 功能概述 通过一个用户的UID（那一串纯数字ID），你可以查询到该用户的昵称、性别、头像、等级、签名等一系列公开的基本信息。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String uid = "483307278"; // String | Bilibili用户的UID
    try {
      GetSocialBilibiliUserinfo200Response result = apiInstance.getSocialBilibiliUserinfo(uid);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialBilibiliUserinfo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **uid** | **String**| Bilibili用户的UID | |

### Return type

[**GetSocialBilibiliUserinfo200Response**](GetSocialBilibiliUserinfo200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 查询成功！返回用户的详细信息。请注意，我们直接透传了B站官方API的返回结构。 |  -  |
| **400** | 缺少uid参数 |  -  |
| **404** | Bilibili用户不存在 |  -  |
| **502** | 上游Bilibili API错误或风控 |  -  |

<a id="getSocialBilibiliVideoinfo"></a>
# **getSocialBilibiliVideoinfo**
> GetSocialBilibiliVideoinfo200Response getSocialBilibiliVideoinfo(aid, bvid)

获取Bilibili视频详细信息

想在你的应用里展示B站视频的详细信息吗？无论是封面、标题，还是播放量、UP主信息，这个接口都能一网打尽。  ## 功能概述 通过提供视频的 &#x60;aid&#x60; 或 &#x60;bvid&#x60;，你可以获取到该视频的完整元数据，包括多P信息、UP主资料、数据统计等。  ## 响应体字段说明 - **&#x60;copyright&#x60; (视频类型)**: &#x60;1&#x60; 代表原创，&#x60;2&#x60; 代表转载。 - **&#x60;owner&#x60; (UP主信息)**: 包含 &#x60;mid&#x60;, &#x60;name&#x60;, &#x60;face&#x60; 等UP主的基本资料。 - **&#x60;stat&#x60; (数据统计)**: 包含了播放、弹幕、评论、点赞、投币、收藏、分享等核心数据。 - **&#x60;pages&#x60; (分P列表)**: 这是一个数组，包含了视频的每一个分P的信息，即使是单P视频也会有一个元素。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String aid = "75836761"; // String | 视频的AV号 (aid)，纯数字格式。`aid`和`bvid`任选其一即可。
    String bvid = "BV17x411w79F"; // String | 视频的BV号 (bvid)，例如 `BV117411r7R1`。`aid`和`bvid`任选其一即可。
    try {
      GetSocialBilibiliVideoinfo200Response result = apiInstance.getSocialBilibiliVideoinfo(aid, bvid);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialBilibiliVideoinfo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **aid** | **String**| 视频的AV号 (aid)，纯数字格式。&#x60;aid&#x60;和&#x60;bvid&#x60;任选其一即可。 | [optional] |
| **bvid** | **String**| 视频的BV号 (bvid)，例如 &#x60;BV117411r7R1&#x60;。&#x60;aid&#x60;和&#x60;bvid&#x60;任选其一即可。 | [optional] |

### Return type

[**GetSocialBilibiliVideoinfo200Response**](GetSocialBilibiliVideoinfo200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功！返回Bilibili视频的详细信息。 |  -  |

<a id="getSocialQqGroupinfo"></a>
# **getSocialQqGroupinfo**
> GetSocialQqGroupinfo200Response getSocialQqGroupinfo(groupId)

获取QQ群名称、头像、简介

想在你的应用里展示QQ群信息？这个接口让你轻松获取群名称、群头像、群简介等公开信息。它能帮你快速构建社群导航站、群聊推荐系统，或是为你的数据分析工具提供可靠的数据源。无论是展示群聊卡片、生成加群链接，还是进行社群数据统计，这个接口都能满足你的需求。  &gt; [!VIP] &gt; 本API目前处于**限时免费**阶段，我们鼓励开发者集成和测试。未来，它将转为付费API，为用户提供更稳定和强大的服务。  ## 功能概述 你只需要提供一个QQ群号（5-12位纯数字），接口就会返回该群的完整公开信息。我们会先验证群号的有效性，确保返回的数据准确可靠。接口的响应速度快，数据结构清晰，非常适合集成到各类应用场景中。  ## 返回数据说明 接口会返回以下QQ群的关键信息： - **群基础信息**: 包括群号、群名称，让你能够准确识别和展示群聊。 - **视觉素材**: 提供群头像URL（标准100x100尺寸），可直接用于在你的界面中展示群聊图标。 - **群介绍资料**: 包含群描述/简介和群标签，帮助用户了解群聊的主题和特色。 - **便捷入口**: 返回加群链接（二维码URL），方便用户一键加入感兴趣的群聊。 - **数据时效**: 提供最后更新时间戳，让你了解数据的新鲜度。  所有返回的数据都遵循标准的JSON格式，字段命名清晰，便于解析和使用。无论你是在做网页端、移动端还是后端服务，都能轻松集成。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String groupId = "526357265"; // String | QQ群号，长度5-12位
    try {
      GetSocialQqGroupinfo200Response result = apiInstance.getSocialQqGroupinfo(groupId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialQqGroupinfo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **groupId** | **String**| QQ群号，长度5-12位 | |

### Return type

[**GetSocialQqGroupinfo200Response**](GetSocialQqGroupinfo200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应，返回QQ群的详细信息 |  -  |
| **400** | 缺少或无效的group_id参数 |  -  |
| **404** | QQ群不存在或无法访问 |  -  |
| **500** | 获取QQ群聊信息失败 |  -  |

<a id="getSocialQqUserinfo"></a>
# **getSocialQqUserinfo**
> GetSocialQqUserinfo200Response getSocialQqUserinfo(qq)

独家获取QQ号头像、昵称

这是一个功能丰富的QQ用户信息查询接口，能够获取QQ用户的详细公开信息。  &gt; [!VIP] &gt; 我们在近日优化了此接口，速度应该会更加快了。   ## 功能概述 通过QQ号查询用户的详细信息，包括基础资料、等级信息、VIP状态等。返回的信息丰富全面，适合用于用户画像分析、社交应用集成等场景。  ## 数据字段说明 - **基础信息**: 昵称、个性签名、头像、年龄、性别 - **联系信息**: QQ邮箱、个性域名(QID) - **等级信息**: QQ等级、VIP状态和等级 - **时间信息**: 注册时间、最后更新时间

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SocialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    SocialApi apiInstance = new SocialApi(defaultClient);
    String qq = "10001"; // String | 需要查询的QQ号
    try {
      GetSocialQqUserinfo200Response result = apiInstance.getSocialQqUserinfo(qq);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SocialApi#getSocialQqUserinfo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **qq** | **String**| 需要查询的QQ号 | |

### Return type

[**GetSocialQqUserinfo200Response**](GetSocialQqUserinfo200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应，返回QQ用户的详细信息 |  -  |
| **400** | 缺少或无效的qq参数 |  -  |
| **404** | 获取QQ用户信息失败或用户不存在 |  -  |

