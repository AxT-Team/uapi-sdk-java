# TextApi

All URIs are relative to *https://uapis.cn/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getTextMd5**](TextApi.md#getTextMd5) | **GET** /text/md5 | MD5 哈希 |
| [**postTextAesDecrypt**](TextApi.md#postTextAesDecrypt) | **POST** /text/aes/decrypt | AES 解密 |
| [**postTextAesDecryptAdvanced**](TextApi.md#postTextAesDecryptAdvanced) | **POST** /text/aes/decrypt-advanced | AES高级解密 |
| [**postTextAesEncrypt**](TextApi.md#postTextAesEncrypt) | **POST** /text/aes/encrypt | AES 加密 |
| [**postTextAesEncryptAdvanced**](TextApi.md#postTextAesEncryptAdvanced) | **POST** /text/aes/encrypt-advanced | AES高级加密 |
| [**postTextAnalyze**](TextApi.md#postTextAnalyze) | **POST** /text/analyze | 文本分析 |
| [**postTextBase64Decode**](TextApi.md#postTextBase64Decode) | **POST** /text/base64/decode | Base64 解码 |
| [**postTextBase64Encode**](TextApi.md#postTextBase64Encode) | **POST** /text/base64/encode | Base64 编码 |
| [**postTextConvert**](TextApi.md#postTextConvert) | **POST** /text/convert | 格式转换 |
| [**postTextMarkdownToHtml**](TextApi.md#postTextMarkdownToHtml) | **POST** /text/markdown-to-html | Markdown 转 HTML |
| [**postTextMarkdownToPdf**](TextApi.md#postTextMarkdownToPdf) | **POST** /text/markdown-to-pdf | Markdown 转 PDF |
| [**postTextMd5**](TextApi.md#postTextMd5) | **POST** /text/md5 | MD5 哈希 (POST) |
| [**postTextMd5Verify**](TextApi.md#postTextMd5Verify) | **POST** /text/md5/verify | MD5 校验 |


<a id="getTextMd5"></a>
# **getTextMd5**
> GetTextMd5200Response getTextMd5(text)

MD5 哈希

一个快速计算文本 MD5 哈希值的工具，适用于短文本且不关心参数暴露的场景。  ## 功能概述 通过GET请求的查询参数传入文本，返回其32位小写的MD5哈希值。  &gt; [!NOTE] &gt; 对于较长或敏感的文本，我们推荐使用本接口的 POST 版本，以避免URL长度限制和参数暴露问题。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    String text = "hello world"; // String | 需要计算哈希值的文本
    try {
      GetTextMd5200Response result = apiInstance.getTextMd5(text);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#getTextMd5");
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
| **text** | **String**| 需要计算哈希值的文本 | |

### Return type

[**GetTextMd5200Response**](GetTextMd5200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 缺少text参数 |  -  |

<a id="postTextAesDecrypt"></a>
# **postTextAesDecrypt**
> PostTextAesDecrypt200Response postTextAesDecrypt(postTextAesDecryptRequest)

AES 解密

收到了用AES加密的密文？把它、密钥和随机数（nonce）交给我们，就能还原出原始内容。  ## 功能概述 这是一个标准的AES解密接口。你需要提供经过Base64编码的密文、加密时使用的密钥和nonce（随机数，通常为16字节字符串）。  &gt; [!IMPORTANT] &gt; **关于密钥 &#x60;key&#x60;** &gt; 我们支持 AES-128, AES-192, 和 AES-256。请确保你提供的密钥 &#x60;key&#x60; 的长度（字节数）正好是 **16**、**24** 或 **32**，以分别对应这三种加密强度。 &gt;  &gt; **关于随机数 &#x60;nonce&#x60;** &gt; 通常为16字节字符串，需与加密时一致。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextAesDecryptRequest postTextAesDecryptRequest = new PostTextAesDecryptRequest(); // PostTextAesDecryptRequest | 
    try {
      PostTextAesDecrypt200Response result = apiInstance.postTextAesDecrypt(postTextAesDecryptRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextAesDecrypt");
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
| **postTextAesDecryptRequest** | [**PostTextAesDecryptRequest**](PostTextAesDecryptRequest.md)|  | |

### Return type

[**PostTextAesDecrypt200Response**](PostTextAesDecrypt200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 无效的请求参数 |  -  |
| **500** | 解密失败 |  -  |

<a id="postTextAesDecryptAdvanced"></a>
# **postTextAesDecryptAdvanced**
> PostTextAesDecryptAdvanced200Response postTextAesDecryptAdvanced(postTextAesDecryptAdvancedRequest)

AES高级解密

需要解密通过高级加密接口加密的数据？这个接口提供与加密接口完全配对的解密功能，支持相同的6种加密模式和3种填充方式。  &gt; [!IMPORTANT] &gt; **解密参数必须与加密时一致** &gt; 解密时，必须提供与加密时相同的密钥、模式和填充方式。对于非GCM模式，还需要提供加密时返回的IV。  ## 功能概述 这是一个功能完整的AES解密接口，能够解密通过高级加密接口加密的所有密文。支持所有6种加密模式和3种填充方式，与加密接口完全配对。  ### 解密流程 1. 获取加密时返回的密文和配置参数 2. 使用相同的密钥、模式、填充方式和IV（如需要） 3. 调用本接口进行解密 4. 获取原始明文  ### 支持的解密模式 - **GCM模式**（推荐）：自动验证数据完整性，如果密文被篡改会解密失败 - **CBC模式**：经典块解密模式，需要提供加密时的IV - **CTR/OFB/CFB模式**：流密码解密，需要提供加密时的IV - **ECB模式**：不需要IV，但安全性较低  ### 填充方式处理 - **PKCS7填充**：解密后自动移除填充 - **Zero填充**：解密后自动移除0x00填充 - **None填充**：无填充处理  ## 参数说明 - **&#x60;text&#x60;**: 待解密的密文（Base64编码，来自加密接口返回的ciphertext字段） - **&#x60;key&#x60;**: 解密密钥（必须与加密时相同） - **&#x60;mode&#x60;**: 加密模式（必须与加密时相同） - **&#x60;padding&#x60;**: 填充方式（可选，默认PKCS7，必须与加密时相同） - **&#x60;iv&#x60;**: 初始化向量（非GCM模式必须提供，Base64编码）  ## 常见错误处理 如果解密失败，请检查以下几点： - 密钥是否与加密时完全相同 - 模式和填充方式是否匹配 - 非GCM模式下是否提供了正确的IV - 密文是否完整且未被修改 - GCM模式下密文是否被篡改

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextAesDecryptAdvancedRequest postTextAesDecryptAdvancedRequest = new PostTextAesDecryptAdvancedRequest(); // PostTextAesDecryptAdvancedRequest | 
    try {
      PostTextAesDecryptAdvanced200Response result = apiInstance.postTextAesDecryptAdvanced(postTextAesDecryptAdvancedRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextAesDecryptAdvanced");
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
| **postTextAesDecryptAdvancedRequest** | [**PostTextAesDecryptAdvancedRequest**](PostTextAesDecryptAdvancedRequest.md)|  | |

### Return type

[**PostTextAesDecryptAdvanced200Response**](PostTextAesDecryptAdvanced200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 解密成功，返回原始明文 |  -  |
| **400** | 无效的请求参数或解密失败 |  -  |

<a id="postTextAesEncrypt"></a>
# **postTextAesEncrypt**
> PostTextAesEncrypt200Response postTextAesEncrypt(postTextAesEncryptRequest)

AES 加密

需要安全地传输或存储一些文本信息？AES加密是一个可靠的选择。  ## 功能概述 这是一个标准的AES加密接口。你提供需要加密的明文和密钥，我们返回经过Base64编码的密文。  &gt; [!IMPORTANT] &gt; **关于密钥 &#x60;key&#x60;** &gt; 我们支持 AES-128, AES-192, 和 AES-256。请确保你提供的密钥 &#x60;key&#x60; 的长度（字节数）正好是 **16**、**24** 或 **32**，以分别对应这三种加密强度。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextAesEncryptRequest postTextAesEncryptRequest = new PostTextAesEncryptRequest(); // PostTextAesEncryptRequest | 
    try {
      PostTextAesEncrypt200Response result = apiInstance.postTextAesEncrypt(postTextAesEncryptRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextAesEncrypt");
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
| **postTextAesEncryptRequest** | [**PostTextAesEncryptRequest**](PostTextAesEncryptRequest.md)|  | |

### Return type

[**PostTextAesEncrypt200Response**](PostTextAesEncrypt200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 无效的请求参数 |  -  |
| **500** | 加密失败 |  -  |

<a id="postTextAesEncryptAdvanced"></a>
# **postTextAesEncryptAdvanced**
> PostTextAesEncryptAdvanced200Response postTextAesEncryptAdvanced(postTextAesEncryptAdvancedRequest)

AES高级加密

需要更灵活的AES加密方案？这个高级接口支持6种加密模式和3种填充方式，让你根据具体场景选择最合适的加密配置。  &gt; [!IMPORTANT] &gt; **推荐使用GCM模式** &gt; GCM模式提供认证加密(AEAD)，不仅能加密数据，还能验证数据完整性，防止密文被篡改。这是目前最推荐的加密模式。  ## 功能概述 这是一个功能全面的AES加密接口，支持多种加密模式和填充方式。你可以根据不同的安全需求和性能要求，灵活选择合适的加密配置。  ### 支持的加密模式 - **GCM模式**（推荐）：认证加密模式，提供完整性保护 - **CBC模式**：经典块加密模式，需要IV和填充，适用于文件加密 - **CTR模式**：流密码模式，无需填充，适用于实时数据加密 - **OFB/CFB模式**：流密码模式，无需填充，适用于流数据加密 - **ECB模式**（不推荐）：仅用于兼容性需求  ### 支持的填充方式 - **PKCS7填充**（推荐）：标准填充方式 - **Zero填充**：使用0x00字节填充 - **None填充**：无填充，用于流密码模式  ### 输出格式支持 - **base64**（默认）：标准Base64编码输出，适合传输和存储 - **hex**：十六进制编码输出，方便进行结果核对  通过 &#x60;output_format&#x60; 参数可以直接获取HEX格式的密文，无需额外调用转换接口。  ## 参数说明 - **&#x60;text&#x60;**: 待加密的明文文本 - **&#x60;key&#x60;**: 加密密钥（支持任意长度） - **&#x60;mode&#x60;**: 加密模式（可选，默认GCM） - **&#x60;padding&#x60;**: 填充方式（可选，默认PKCS7） - **&#x60;iv&#x60;**: 自定义IV（可选，Base64编码，16字节） - **&#x60;output_format&#x60;**: 输出格式（可选，默认base64）  ## 使用示例  **示例1：HEX格式输出** &#x60;&#x60;&#x60;json {   \&quot;text\&quot;: \&quot;测试文本123\&quot;,   \&quot;key\&quot;: \&quot;1234567890123456\&quot;,   \&quot;mode\&quot;: \&quot;ECB\&quot;,   \&quot;padding\&quot;: \&quot;PKCS7\&quot;,   \&quot;output_format\&quot;: \&quot;hex\&quot; } &#x60;&#x60;&#x60; 返回示例： &#x60;&#x60;&#x60;json {   \&quot;ciphertext\&quot;: \&quot;aaaca6027da10918bb5d23d81939552c\&quot;,   \&quot;mode\&quot;: \&quot;ECB\&quot;,   \&quot;padding\&quot;: \&quot;PKCS7\&quot; } &#x60;&#x60;&#x60;  **示例2：Base64格式输出（默认）** &#x60;&#x60;&#x60;json {   \&quot;text\&quot;: \&quot;测试文本123\&quot;,   \&quot;key\&quot;: \&quot;1234567890123456\&quot;,   \&quot;mode\&quot;: \&quot;ECB\&quot;,   \&quot;padding\&quot;: \&quot;PKCS7\&quot; } &#x60;&#x60;&#x60; 返回示例： &#x60;&#x60;&#x60;json {   \&quot;ciphertext\&quot;: \&quot;qqymAn2hCRi7XSPYGTlVLA&#x3D;&#x3D;\&quot;,   \&quot;mode\&quot;: \&quot;ECB\&quot;,   \&quot;padding\&quot;: \&quot;PKCS7\&quot; } &#x60;&#x60;&#x60;  ## 技术规格 - **加密算法**: AES-256 - **编码格式**: Base64/HEX（输入/输出） - **IV长度**: 16字节（128位）  &gt; [!NOTE] &gt; **关于IV（初始化向量）** &gt; - GCM模式无需提供IV &gt; - CBC/CTR/OFB/CFB模式可选提供IV &gt; - ECB模式不使用IV &gt; - 建议每次加密使用不同的IV以确保安全性  &gt; [!TIP] &gt; **关于输出格式** &gt; - 如需核对输出结果，建议使用 &#x60;output_format: \&quot;hex\&quot;&#x60; &gt; - Base64格式更适合网络传输和API调用 &gt; - 两种格式可以相互转换，数据完全一致

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextAesEncryptAdvancedRequest postTextAesEncryptAdvancedRequest = new PostTextAesEncryptAdvancedRequest(); // PostTextAesEncryptAdvancedRequest | 
    try {
      PostTextAesEncryptAdvanced200Response result = apiInstance.postTextAesEncryptAdvanced(postTextAesEncryptAdvancedRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextAesEncryptAdvanced");
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
| **postTextAesEncryptAdvancedRequest** | [**PostTextAesEncryptAdvancedRequest**](PostTextAesEncryptAdvancedRequest.md)|  | |

### Return type

[**PostTextAesEncryptAdvanced200Response**](PostTextAesEncryptAdvanced200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 加密成功，返回密文和加密配置 |  -  |
| **400** | 无效的请求参数 |  -  |

<a id="postTextAnalyze"></a>
# **postTextAnalyze**
> PostTextAnalyze200Response postTextAnalyze(postTextAnalyzeRequest)

文本分析

想知道一篇文章有多少字、多少个词、或者多少行？这个接口可以帮你快速统计。  ## 功能概述 你提供一段文本，我们会从多个维度进行分析，并返回其字符数、词数、句子数、段落数和行数。这对于文本编辑、内容管理等场景非常有用。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextAnalyzeRequest postTextAnalyzeRequest = new PostTextAnalyzeRequest(); // PostTextAnalyzeRequest | 
    try {
      PostTextAnalyze200Response result = apiInstance.postTextAnalyze(postTextAnalyzeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextAnalyze");
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
| **postTextAnalyzeRequest** | [**PostTextAnalyzeRequest**](PostTextAnalyzeRequest.md)|  | |

### Return type

[**PostTextAnalyze200Response**](PostTextAnalyze200Response.md)

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

<a id="postTextBase64Decode"></a>
# **postTextBase64Decode**
> PostTextBase64Decode200Response postTextBase64Decode(postTextBase64DecodeRequest)

Base64 解码

这是一个简单实用的 Base64 解码工具。  ## 功能概述 你提供一个 Base64 编码的字符串，我们帮你解码成原始的 UTF-8 文本。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextBase64DecodeRequest postTextBase64DecodeRequest = new PostTextBase64DecodeRequest(); // PostTextBase64DecodeRequest | 
    try {
      PostTextBase64Decode200Response result = apiInstance.postTextBase64Decode(postTextBase64DecodeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextBase64Decode");
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
| **postTextBase64DecodeRequest** | [**PostTextBase64DecodeRequest**](PostTextBase64DecodeRequest.md)|  | |

### Return type

[**PostTextBase64Decode200Response**](PostTextBase64Decode200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 无效的请求参数或解码失败 |  -  |

<a id="postTextBase64Encode"></a>
# **postTextBase64Encode**
> PostTextBase64Encode200Response postTextBase64Encode(postTextBase64EncodeRequest)

Base64 编码

这是一个简单实用的 Base64 编码工具。  ## 功能概述 你提供一段原始文本，我们帮你转换成 Base64 编码的字符串。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextBase64EncodeRequest postTextBase64EncodeRequest = new PostTextBase64EncodeRequest(); // PostTextBase64EncodeRequest | 
    try {
      PostTextBase64Encode200Response result = apiInstance.postTextBase64Encode(postTextBase64EncodeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextBase64Encode");
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
| **postTextBase64EncodeRequest** | [**PostTextBase64EncodeRequest**](PostTextBase64EncodeRequest.md)|  | |

### Return type

[**PostTextBase64Encode200Response**](PostTextBase64Encode200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 无效的请求参数 |  -  |

<a id="postTextConvert"></a>
# **postTextConvert**
> PostTextConvert200Response postTextConvert(postTextConvertRequest)

格式转换

需要在不同文本格式之间转换？这个接口支持Base64、Hex、URL、HTML、Unicode等多种格式互转，还能生成MD5、SHA256等哈希值。  ## 功能概述 你提供待转换的文本、源格式和目标格式，接口会自动完成转换。支持7种双向格式（plain、base64、hex、url、html、unicode、binary）和4种单向哈希（md5、sha1、sha256、sha512）。  ## 格式说明 **双向转换格式**：plain（纯文本）、base64、hex（十六进制）、url、html（HTML实体）、unicode（\\uXXXX转义）、binary（二进制字符串）  **单向哈希格式**：md5、sha1、sha256、sha512（仅可作为目标格式，不可逆）  ## 链式转换 支持多次调用实现复杂转换，如先将文本转为base64，再将base64转为hex。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextConvertRequest postTextConvertRequest = new PostTextConvertRequest(); // PostTextConvertRequest | 
    try {
      PostTextConvert200Response result = apiInstance.postTextConvert(postTextConvertRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextConvert");
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
| **postTextConvertRequest** | [**PostTextConvertRequest**](PostTextConvertRequest.md)|  | |

### Return type

[**PostTextConvert200Response**](PostTextConvert200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 转换成功 |  -  |
| **400** | 转换失败或参数错误 |  -  |

<a id="postTextMarkdownToHtml"></a>
# **postTextMarkdownToHtml**
> PostTextMarkdownToHtml200Response postTextMarkdownToHtml(postTextMarkdownToHtmlRequest)

Markdown 转 HTML

直接调用这个接口，就可以把 Markdown 文本转换成带样式的 HTML，而且它不只适合程序里动态注入，也适合在开发阶段直接预览。  ## 如何使用与预览 - **默认模式：返回 JSON 里的 HTML 片段**：不传 &#x60;format&#x60; 时，接口会返回 JSON。您只需要读取响应里的 &#x60;data.html&#x60;，再赋值给前端容器，例如 &#x60;element.innerHTML &#x3D; data.html&#x60;、Vue 的 &#x60;v-html&#x60;，或者 React 里配合 &#x60;dangerouslySetInnerHTML&#x60; 使用。 - **预览模式：直接返回完整 HTML 网页**：如果您想在浏览器里直接打开结果，或者想把响应保存成一个独立的 &#x60;.html&#x60; 文件，请传 &#x60;format&#x3D;\&quot;html\&quot;&#x60;。这个模式下，接口会直接返回带 &#x60;&lt;!DOCTYPE html&gt;&lt;html&gt;...&#x60; 的完整网页源码。  ## 功能概述 - **自带精美排版，无需手写 CSS**：返回结果已经内置样式，标题、引用、表格、任务列表和代码块都可以直接显示。 - **支持丰富的排版元素**：除了标准 Markdown，这个接口也可以正确处理 GFM 常见语法，例如表格、任务列表和带语言标记的代码块。 - **安全处理用户内容**：默认开启安全模式，会自动过滤原始 HTML 里的风险脚本。如果内容来源绝对可信，并且您确实需要保留原始 HTML，可以把 &#x60;sanitize&#x60; 设为 &#x60;false&#x60;。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextMarkdownToHtmlRequest postTextMarkdownToHtmlRequest = new PostTextMarkdownToHtmlRequest(); // PostTextMarkdownToHtmlRequest | 请求体使用 `application/json`。`text` 必填；`format` 和 `sanitize` 可选。
    try {
      PostTextMarkdownToHtml200Response result = apiInstance.postTextMarkdownToHtml(postTextMarkdownToHtmlRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextMarkdownToHtml");
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
| **postTextMarkdownToHtmlRequest** | [**PostTextMarkdownToHtmlRequest**](PostTextMarkdownToHtmlRequest.md)| 请求体使用 &#x60;application/json&#x60;。&#x60;text&#x60; 必填；&#x60;format&#x60; 和 &#x60;sanitize&#x60; 可选。 | |

### Return type

[**PostTextMarkdownToHtml200Response**](PostTextMarkdownToHtml200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/html

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 转换成功。具体返回 JSON 还是纯 HTML，由 &#x60;format&#x60; 参数决定。 |  -  |
| **400** | 请求参数错误。可能是请求体格式错误、&#x60;text&#x60; 为空，或者 &#x60;format&#x60; 取值不合法。 |  -  |
| **413** | Markdown 文本超过当前大小限制。 |  -  |
| **500** | 转换过程中发生错误，请稍后再试。 |  -  |
| **503** | 服务暂时不可用。 |  -  |

<a id="postTextMarkdownToPdf"></a>
# **postTextMarkdownToPdf**
> File postTextMarkdownToPdf(postTextMarkdownToPdfRequest)

Markdown 转 PDF

当您的业务系统需要提供“导出为 PDF”的功能时，无需在后端部署复杂的排版引擎，只需将 Markdown 文本发给这个接口，即可直接获取打印级的 PDF 文件。  ## 功能概述 - **服务端直接生成**：接口直接返回 PDF 文件二进制流，前端无需任何处理即可触发下载，后端也能轻松存盘归档。 - **多种精美主题与纸张**：内置了 GitHub、暗黑等多种专业排版主题，并支持 A4、Letter 等标准纸张。只需简单配置，就能生成符合业务场景的专业文档。 - **公网图片也可以直接带入 PDF**：除了纯文本和标准 Markdown 语法，这个接口也可以处理 &#x60;data URI&#x60; 图片，或者公网可访问的 &#x60;http&#x60;、&#x60;https&#x60; 图片链接。服务端会先通过代理抓取图片，并在渲染前内联到文档里，同时带有超时控制。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextMarkdownToPdfRequest postTextMarkdownToPdfRequest = new PostTextMarkdownToPdfRequest(); // PostTextMarkdownToPdfRequest | 请求体使用 `application/json`。`text` 必填，`theme` 和 `paper_size` 可选。
    try {
      File result = apiInstance.postTextMarkdownToPdf(postTextMarkdownToPdfRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextMarkdownToPdf");
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
| **postTextMarkdownToPdfRequest** | [**PostTextMarkdownToPdfRequest**](PostTextMarkdownToPdfRequest.md)| 请求体使用 &#x60;application/json&#x60;。&#x60;text&#x60; 必填，&#x60;theme&#x60; 和 &#x60;paper_size&#x60; 可选。 | |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/pdf, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 转换成功。响应体是 PDF 二进制文件流。 |  * Content-Disposition - 提示客户端按 PDF 文件处理，默认文件名为 &#x60;markdown.pdf&#x60;。 <br>  * Cache-Control - 禁止缓存本次导出的 PDF 响应。 <br>  |
| **400** | 请求参数不合法，或者 Markdown 内容包含当前不允许的内容。 |  -  |
| **413** | Markdown 文本，或 Markdown 中引用的图片资源超过当前大小限制。 |  -  |
| **500** | PDF 生成失败，请稍后再试。 |  -  |
| **502** | Markdown 中引用的图片下载失败，或远端返回的不是可识别的图片内容。 |  -  |
| **503** | PDF 渲染服务暂时不可用。 |  -  |
| **504** | Markdown 中引用的图片下载超时。 |  -  |

<a id="postTextMd5"></a>
# **postTextMd5**
> GetTextMd5200Response postTextMd5(postTextMd5Request)

MD5 哈希 (POST)

一个用于计算文本 MD5 哈希值的标准工具，推荐使用此版本。  ## 功能概述 通过POST请求的表单体传入文本，返回其32位小写的MD5哈希值。相比GET版本，此方法更适合处理较长或包含敏感信息的文本。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextMd5Request postTextMd5Request = new PostTextMd5Request(); // PostTextMd5Request | 
    try {
      GetTextMd5200Response result = apiInstance.postTextMd5(postTextMd5Request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextMd5");
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
| **postTextMd5Request** | [**PostTextMd5Request**](PostTextMd5Request.md)|  | |

### Return type

[**GetTextMd5200Response**](GetTextMd5200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 缺少text参数 |  -  |

<a id="postTextMd5Verify"></a>
# **postTextMd5Verify**
> PostTextMd5Verify200Response postTextMd5Verify(postTextMd5VerifyRequest)

MD5 校验

下载了一个文件，想确认它在传输过程中有没有损坏？校验MD5值是最常用的方法。  ## 功能概述 你提供原始文本和一个MD5哈希值，我们帮你计算文本的哈希，并与你提供的哈希进行比对，告诉你它们是否匹配。这在文件完整性校验等场景下非常有用。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TextApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    TextApi apiInstance = new TextApi(defaultClient);
    PostTextMd5VerifyRequest postTextMd5VerifyRequest = new PostTextMd5VerifyRequest(); // PostTextMd5VerifyRequest | 
    try {
      PostTextMd5Verify200Response result = apiInstance.postTextMd5Verify(postTextMd5VerifyRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TextApi#postTextMd5Verify");
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
| **postTextMd5VerifyRequest** | [**PostTextMd5VerifyRequest**](PostTextMd5VerifyRequest.md)|  | |

### Return type

[**PostTextMd5Verify200Response**](PostTextMd5Verify200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功响应 |  -  |
| **400** | 无效的请求参数 |  -  |

