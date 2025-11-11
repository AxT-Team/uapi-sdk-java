# DefaultApi

All URIs are relative to *https://uapis.cn/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSearchEngines**](DefaultApi.md#getSearchEngines) | **GET** /search/engines | 获取搜索引擎信息 |
| [**getSensitiveWordAnalyzeQuery**](DefaultApi.md#getSensitiveWordAnalyzeQuery) | **GET** /sensitive-word/analyze-query | 查询参数分析 |
| [**postSearchAggregate**](DefaultApi.md#postSearchAggregate) | **POST** /search/aggregate | 智能搜索 |
| [**postSensitiveWordAnalyze**](DefaultApi.md#postSensitiveWordAnalyze) | **POST** /sensitive-word/analyze | 分析敏感词 |
| [**postSensitiveWordQuickCheck**](DefaultApi.md#postSensitiveWordQuickCheck) | **POST** /text/profanitycheck | 敏感词检测（快速） |


<a id="getSearchEngines"></a>
# **getSearchEngines**
> GetSearchEngines200Response getSearchEngines()

获取搜索引擎信息

获取 UAPI Pro Search 引擎的详细信息，包括支持的功能特性、参数限制和使用说明。  ## 功能概述  此接口返回搜索引擎的完整配置信息，你可以用它来： - 了解搜索引擎支持哪些功能（如站内搜索、文件类型过滤等） - 获取参数的默认值和限制范围 - 查看当前引擎版本和可用状态  适合在应用初始化时调用，或用于动态配置搜索界面。       

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      GetSearchEngines200Response result = apiInstance.getSearchEngines();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getSearchEngines");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSearchEngines200Response**](GetSearchEngines200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功返回搜索引擎的详细信息 |  -  |

<a id="getSensitiveWordAnalyzeQuery"></a>
# **getSensitiveWordAnalyzeQuery**
> PostSensitiveWordAnalyze200Response getSensitiveWordAnalyzeQuery(keyword)

查询参数分析

通过URL查询参数分析单个关键词，便于GET请求调用。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String keyword = "喵"; // String | 要分析的关键词，最长50字符。
    try {
      PostSensitiveWordAnalyze200Response result = apiInstance.getSensitiveWordAnalyzeQuery(keyword);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getSensitiveWordAnalyzeQuery");
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
| **keyword** | **String**| 要分析的关键词，最长50字符。 | |

### Return type

[**PostSensitiveWordAnalyze200Response**](PostSensitiveWordAnalyze200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 分析成功 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 未授权访问 |  -  |

<a id="postSearchAggregate"></a>
# **postSearchAggregate**
> PostSearchAggregate200Response postSearchAggregate(postSearchAggregateRequest)

智能搜索

想在你的应用中集成搜索功能？我们提供了一个强大的搜索引擎API，让你可以轻松实现实时网页搜索。  ## 功能概述  UAPI Pro Search 是自研的智能搜索引擎，采用机器学习算法对搜索结果进行智能排序，确保最相关的内容排在前面。你可以用它搜索任何关键词，也可以限定在特定网站或特定文件类型中搜索。  - **实时网页搜索**: 毫秒级响应，快速返回搜索结果 - **智能排序**: 采用机器学习回归排序算法，结果更精准 - **站内搜索**: 支持 &#x60;site:&#x60; 操作符，在指定网站内搜索 - **文件类型过滤**: 支持 &#x60;filetype:&#x60; 操作符，快速找到 PDF、Word 等特定格式文件  &gt; [!VIP] &gt; 本API目前处于**限时免费**阶段，我们鼓励开发者集成和测试。未来，它将转为付费API，为用户提供更稳定和强大的服务。       

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    PostSearchAggregateRequest postSearchAggregateRequest = new PostSearchAggregateRequest(); // PostSearchAggregateRequest | 包含搜索参数的JSON对象
    try {
      PostSearchAggregate200Response result = apiInstance.postSearchAggregate(postSearchAggregateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#postSearchAggregate");
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
| **postSearchAggregateRequest** | [**PostSearchAggregateRequest**](PostSearchAggregateRequest.md)| 包含搜索参数的JSON对象 | |

### Return type

[**PostSearchAggregate200Response**](PostSearchAggregate200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 搜索成功，返回经过AI排序的高质量结果 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 未授权 |  -  |
| **429** | 请求过于频繁 |  -  |
| **500** | 服务器内部错误 |  -  |

<a id="postSensitiveWordAnalyze"></a>
# **postSensitiveWordAnalyze**
> PostSensitiveWordAnalyze200Response postSensitiveWordAnalyze(postSensitiveWordAnalyzeRequest)

分析敏感词

分析单个或多个关键词的敏感程度，返回详细的风险评分和分析结果。  &gt; [!VIP] &gt; 本API基于先进的分析模型，提供三级缓存策略和并发处理能力。  ## 功能概述  - **模型驱动**: 使用先进的分析模型进行语义分析。 - **高性能**: 采用三级缓存策略（持久化存储 → 统一缓存 → 模型分析），确保高频请求的响应速度。 - **并发支持**: 支持批量并发处理，单次最多可分析100个关键词。 - **详细评分**: 提供色情、辱骂、暴力三个维度的详细风险评分。 - **变体识别**: 能够自动识别关键词的常见变体形式，如拼音、缩写等。  ## 风险评分说明  返回的 &#x60;s&#x60; 字段包含三个维度的风险评分，范围均为0.0至1.0：  - **s[0] - 色情风险**: 评估内容涉及色情信息的程度。 - **s[1] - 辱骂/仇恨言论风险**: 评估内容是否包含侮辱性或仇恨性言论。 - **s[2] - 暴力/威胁风险**: 评估内容是否涉及暴力或威胁信息。  风险等级可参考：0.0-0.3为低风险，0.3-0.7为中等风险，0.7-1.0为高风险。  ## 响应字段说明  | 字段 | 类型 | 说明 | |------|------|------| | &#x60;results&#x60; | array | 分析结果对象的数组。 | | &#x60;results[].k&#x60; | string | 您在请求中提供的原始关键词。 | | &#x60;results[].r&#x60; | string | 模型对该关键词的分析过程和判断理由的简要说明。 | | &#x60;results[].s&#x60; | array[float] | 一个包含三个浮点数的数组，分别代表[色情, 辱骂, 暴力]三个维度的风险评分。分值范围从0.0到1.0，越高代表风险越大。 | | &#x60;results[].v&#x60; | array[string] | 模型识别出的该关键词的常见变体形式，例如拼音、谐音、缩写等。 | | &#x60;results[].t&#x60; | array[string] | 根据分析结果为关键词附加的分类标签，便于进行程序化处理和过滤。 | | &#x60;results[].d&#x60; | string | 对整体分析结果的一句简短总结，适合直接展示给用户或记录在日志中。 | | &#x60;total&#x60; | integer | 本次请求成功分析的关键词总数。 |       

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    PostSensitiveWordAnalyzeRequest postSensitiveWordAnalyzeRequest = new PostSensitiveWordAnalyzeRequest(); // PostSensitiveWordAnalyzeRequest | 包含待检测文本 'keywords' 的JSON对象
    try {
      PostSensitiveWordAnalyze200Response result = apiInstance.postSensitiveWordAnalyze(postSensitiveWordAnalyzeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#postSensitiveWordAnalyze");
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
| **postSensitiveWordAnalyzeRequest** | [**PostSensitiveWordAnalyzeRequest**](PostSensitiveWordAnalyzeRequest.md)| 包含待检测文本 &#39;keywords&#39; 的JSON对象 | |

### Return type

[**PostSensitiveWordAnalyze200Response**](PostSensitiveWordAnalyze200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 分析成功 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 未授权访问 |  -  |
| **429** | 请求频率超限 |  -  |

<a id="postSensitiveWordQuickCheck"></a>
# **postSensitiveWordQuickCheck**
> PostSensitiveWordQuickCheck200Response postSensitiveWordQuickCheck(postSensitiveWordQuickCheckRequest)

敏感词检测（快速）

在你的社区或应用中，需要来过滤掉不和谐的声音吗？这个接口可以助你一臂之力。  ## 功能概述  我们对敏感词检测接口进行了大幅升级，现在采用高效的 **Aho-Corasick 算法**，实现了多模式字符串匹配。这意味着你不再需要手动编写复杂的正则表达式，系统会自动高效地检测出文本中的所有敏感词。  ### 主要特性  - **高性能算法**：基于 Aho-Corasick 算法，单次扫描即可检测多个敏感词模式 - **简繁体支持**：自动识别和处理简体中文、繁体中文内容 - **多模匹配**：无需编写正则表达式，系统内置智能匹配逻辑 - **快速响应**：相比传统方法，检测速度显著提升  无论是论坛、社交平台还是评论系统，这个接口都能帮你快速构建内容审核功能。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    PostSensitiveWordQuickCheckRequest postSensitiveWordQuickCheckRequest = new PostSensitiveWordQuickCheckRequest(); // PostSensitiveWordQuickCheckRequest | 包含待检测文本 'text' 的JSON对象
    try {
      PostSensitiveWordQuickCheck200Response result = apiInstance.postSensitiveWordQuickCheck(postSensitiveWordQuickCheckRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#postSensitiveWordQuickCheck");
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
| **postSensitiveWordQuickCheckRequest** | [**PostSensitiveWordQuickCheckRequest**](PostSensitiveWordQuickCheckRequest.md)| 包含待检测文本 &#39;text&#39; 的JSON对象 | |

### Return type

[**PostSensitiveWordQuickCheck200Response**](PostSensitiveWordQuickCheck200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 请求体无效或文本为空 |  -  |

