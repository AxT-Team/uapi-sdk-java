# WebParseApi

All URIs are relative to *https://uapis.cn/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getWebTomarkdownAsyncStatus**](WebParseApi.md#getWebTomarkdownAsyncStatus) | **GET** /web/tomarkdown/async/{task_id} | 转换任务状态 |
| [**getWebparseExtractimages**](WebParseApi.md#getWebparseExtractimages) | **GET** /webparse/extractimages | 提取网页图片 |
| [**getWebparseMetadata**](WebParseApi.md#getWebparseMetadata) | **GET** /webparse/metadata | 提取网页元数据 |
| [**postWebTomarkdownAsync**](WebParseApi.md#postWebTomarkdownAsync) | **POST** /web/tomarkdown/async | 网页转 Markdown |


<a id="getWebTomarkdownAsyncStatus"></a>
# **getWebTomarkdownAsyncStatus**
> GetWebTomarkdownAsyncStatus200Response getWebTomarkdownAsyncStatus(taskId)

转换任务状态

提交了网页转 Markdown 任务后，想知道处理进度和结果？用这个接口来查询。  ## 功能概述 通过任务 ID 查询转换任务的当前状态、处理进度和最终结果。任务结果缓存 30 分钟，期间可重复查询。  ## 任务状态  | 状态 | 说明 | |------|------| | &#x60;pending&#x60; | 等待处理 | | &#x60;processing&#x60; | 处理中 | | &#x60;completed&#x60; | 已完成，可获取结果 | | &#x60;failed&#x60; | 失败 | | &#x60;timeout&#x60; | 超时（超过 60 秒） |  &gt; [!NOTE] &gt; 建议每 2-5 秒轮询一次，当状态为 &#x60;completed&#x60;、&#x60;failed&#x60; 或 &#x60;timeout&#x60; 时停止轮询。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.WebParseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    WebParseApi apiInstance = new WebParseApi(defaultClient);
    String taskId = "a1b2c3d4-e5f6-47a8-b9c0-d1e2f3a4b5c6"; // String | 任务ID（由提交接口返回）
    try {
      GetWebTomarkdownAsyncStatus200Response result = apiInstance.getWebTomarkdownAsyncStatus(taskId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebParseApi#getWebTomarkdownAsyncStatus");
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
| **taskId** | **String**| 任务ID（由提交接口返回） | |

### Return type

[**GetWebTomarkdownAsyncStatus200Response**](GetWebTomarkdownAsyncStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取任务状态（包含各种状态的响应） |  -  |
| **404** | 任务不存在或已过期 |  -  |

<a id="getWebparseExtractimages"></a>
# **getWebparseExtractimages**
> GetWebparseExtractimages200Response getWebparseExtractimages(url)

提取网页图片

想批量获取一个网页上的所有图片链接？这个接口帮你搞定。  ## 功能概述 提供一个网页 URL，返回该页面中所有图片的链接列表。适合用于图片采集、素材下载等场景。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.WebParseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    WebParseApi apiInstance = new WebParseApi(defaultClient);
    URI url = new URI(); // URI | 需要提取图片的网页URL
    try {
      GetWebparseExtractimages200Response result = apiInstance.getWebparseExtractimages(url);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebParseApi#getWebparseExtractimages");
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
| **url** | **URI**| 需要提取图片的网页URL | |

### Return type

[**GetWebparseExtractimages200Response**](GetWebparseExtractimages200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | URL参数缺失或无效 |  -  |
| **500** | 服务器内部错误 |  -  |

<a id="getWebparseMetadata"></a>
# **getWebparseMetadata**
> GetWebparseMetadata200Response getWebparseMetadata(url)

提取网页元数据

想在应用里做链接预览卡片？这个接口帮你一键获取网页的标题、描述、图标等信息。  ## 功能概述 提供一个网页 URL，返回该页面的元数据，包括标题、描述、关键词、Favicon、Open Graph 信息等。非常适合用于生成链接预览卡片或做 SEO 分析。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.WebParseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    WebParseApi apiInstance = new WebParseApi(defaultClient);
    URI url = new URI(); // URI | 需要提取元数据的网页URL
    try {
      GetWebparseMetadata200Response result = apiInstance.getWebparseMetadata(url);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebParseApi#getWebparseMetadata");
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
| **url** | **URI**| 需要提取元数据的网页URL | |

### Return type

[**GetWebparseMetadata200Response**](GetWebparseMetadata200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | URL参数缺失或无效 |  -  |
| **500** | 服务器内部错误 |  -  |

<a id="postWebTomarkdownAsync"></a>
# **postWebTomarkdownAsync**
> PostWebTomarkdownAsync202Response postWebTomarkdownAsync(url)

网页转 Markdown

想把一个网页的内容转成干净的 Markdown 文本？这个异步接口可以帮你搞定，特别适合处理大型或复杂的网页。  ## 功能概述  &gt; [!VIP] &gt; 本 API 目前处于**限时免费**阶段，未来将转为付费服务。  提交一个网页 URL，我们会自动抓取主体内容，剔除广告、导航栏等干扰元素，并转换为 Markdown 格式。同时会提取标题、作者、发布日期等元数据，生成 YAML Front Matter。  任务提交后会立即返回任务 ID，你可以用它来查询处理进度和结果。单个任务最长处理 60 秒，结果缓存 30 分钟。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.WebParseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    WebParseApi apiInstance = new WebParseApi(defaultClient);
    String url = "https://example.com"; // String | 需要转换的网页URL。URL必须经过编码。
    try {
      PostWebTomarkdownAsync202Response result = apiInstance.postWebTomarkdownAsync(url);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebParseApi#postWebTomarkdownAsync");
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
| **url** | **String**| 需要转换的网页URL。URL必须经过编码。 | |

### Return type

[**PostWebTomarkdownAsync202Response**](PostWebTomarkdownAsync202Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | 任务已提交成功，返回任务ID |  -  |
| **400** | 请求参数错误 |  -  |

