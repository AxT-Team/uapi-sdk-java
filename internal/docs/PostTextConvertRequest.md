

# PostTextConvertRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**text** | **String** | 待转换的文本内容 |  |
|**from** | [**FromEnum**](#FromEnum) | 源格式类型 |  |
|**to** | [**ToEnum**](#ToEnum) | 目标格式类型 |  |
|**options** | **Map&lt;String, Object&gt;** | 可选参数（预留，当前未使用） |  [optional] |



## Enum: FromEnum

| Name | Value |
|---- | -----|
| PLAIN | &quot;plain&quot; |
| BASE64 | &quot;base64&quot; |
| HEX | &quot;hex&quot; |
| URL | &quot;url&quot; |
| HTML | &quot;html&quot; |
| UNICODE | &quot;unicode&quot; |
| BINARY | &quot;binary&quot; |
| MD5 | &quot;md5&quot; |
| SHA1 | &quot;sha1&quot; |
| SHA256 | &quot;sha256&quot; |
| SHA512 | &quot;sha512&quot; |



## Enum: ToEnum

| Name | Value |
|---- | -----|
| PLAIN | &quot;plain&quot; |
| BASE64 | &quot;base64&quot; |
| HEX | &quot;hex&quot; |
| URL | &quot;url&quot; |
| HTML | &quot;html&quot; |
| UNICODE | &quot;unicode&quot; |
| BINARY | &quot;binary&quot; |
| MD5 | &quot;md5&quot; |
| SHA1 | &quot;sha1&quot; |
| SHA256 | &quot;sha256&quot; |
| SHA512 | &quot;sha512&quot; |



