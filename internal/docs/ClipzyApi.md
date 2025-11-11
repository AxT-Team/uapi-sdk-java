# ClipzyApi

All URIs are relative to *https://uapis.cn/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getClipzyGet**](ClipzyApi.md#getClipzyGet) | **GET** /api/get | 步骤2 (方法一): 获取加密数据 |
| [**getClipzyRaw**](ClipzyApi.md#getClipzyRaw) | **GET** /api/raw/{id} | 步骤2 (方法二): 获取原始文本 |
| [**postClipzyStore**](ClipzyApi.md#postClipzyStore) | **POST** /api/store | 步骤1：上传加密数据 |


<a id="getClipzyGet"></a>
# **getClipzyGet**
> GetClipzyGet200Response getClipzyGet(id)

步骤2 (方法一): 获取加密数据

**此接口用于“最高安全等级”方法。**  您提供第一步中获得的ID，它会返回存储在服务器上的**加密数据**。您需要在自己的客户端中，使用您自己保管的密钥来解密它。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClipzyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    ClipzyApi apiInstance = new ClipzyApi(defaultClient);
    String id = "PREF0Zv8Yj"; // String | 片段的唯一 ID。
    try {
      GetClipzyGet200Response result = apiInstance.getClipzyGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClipzyApi#getClipzyGet");
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
| **id** | **String**| 片段的唯一 ID。 | |

### Return type

[**GetClipzyGet200Response**](GetClipzyGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 获取成功！返回加密并压缩后的数据。 |  -  |
| **400** | 请求参数错误，通常是缺少 &#x60;id&#x60; 参数。 |  -  |
| **404** | 片段未找到。它可能已过期、被删除或ID不正确。 |  -  |

<a id="getClipzyRaw"></a>
# **getClipzyRaw**
> String getClipzyRaw(id, key)

步骤2 (方法二): 获取原始文本

**此接口用于“方便自动化”方法。**  您提供第一步获得的ID，并附上您自己保管的**解密密钥**作为 &#x60;key&#x60; 参数。服务器会直接为您解密，并返回纯文本内容。  &gt; [!IMPORTANT] &gt; 查看文档首页的 **cURL 示例**，了解此接口最典型的用法。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClipzyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    ClipzyApi apiInstance = new ClipzyApi(defaultClient);
    String id = "PREF0Zv8Yj"; // String | 片段的唯一 ID。
    String key = "ES9tGP0v3e7oqzmAk3vMboxVOOBlvw9RS3DszeW675k="; // String | 用于解密的 Base64 编码的 AES 密钥。
    try {
      String result = apiInstance.getClipzyRaw(id, key);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClipzyApi#getClipzyRaw");
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
| **id** | **String**| 片段的唯一 ID。 | |
| **key** | **String**| 用于解密的 Base64 编码的 AES 密钥。 | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 解密并获取成功！响应体为纯文本内容。 |  -  |
| **400** | 请求参数错误，缺少 ID 或密钥。 |  -  |
| **403** | 禁止访问。提供的密钥无法解密对应的数据。 |  -  |
| **404** | 片段未找到。它可能已过期、被删除或ID不正确。 |  -  |

<a id="postClipzyStore"></a>
# **postClipzyStore**
> PostClipzyStore200Response postClipzyStore(postClipzyStoreRequest)

步骤1：上传加密数据

这是所有流程的第一步。您的客户端应用需要先在本地准备好 **加密后的数据**，然后调用此接口进行上传。成功后，您会得到一个用于后续操作的唯一ID。  &gt; [!NOTE] &gt; 您发送给此接口的应该是**密文**，而不是原始文本。请参考文档首页的JavaScript示例来了解如何在客户端进行加密。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClipzyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://uapis.cn/api/v1");

    ClipzyApi apiInstance = new ClipzyApi(defaultClient);
    PostClipzyStoreRequest postClipzyStoreRequest = new PostClipzyStoreRequest(); // PostClipzyStoreRequest | 包含加密数据和可选的TTL。
    try {
      PostClipzyStore200Response result = apiInstance.postClipzyStore(postClipzyStoreRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClipzyApi#postClipzyStore");
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
| **postClipzyStoreRequest** | [**PostClipzyStoreRequest**](PostClipzyStoreRequest.md)| 包含加密数据和可选的TTL。 | |

### Return type

[**PostClipzyStore200Response**](PostClipzyStore200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 片段创建成功！返回该片段的唯一ID。 |  -  |
| **400** | 请求体缺失、格式错误或参数无效。 |  -  |
| **413** | 请求体过大。上传的数据（压缩后）超过了服务器限制。 |  -  |

