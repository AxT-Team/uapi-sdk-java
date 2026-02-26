

# PostTextAesEncryptAdvancedRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**text** | **String** | 待加密的明文文本 |  |
|**key** | **String** | 加密密钥（支持任意长度） |  |
|**mode** | [**ModeEnum**](#ModeEnum) | 加密模式：GCM/CBC/ECB/CTR/OFB/CFB（可选，默认GCM） |  [optional] |
|**padding** | [**PaddingEnum**](#PaddingEnum) | 填充方式：PKCS7/ZERO/NONE（可选，默认PKCS7） |  [optional] |
|**iv** | **String** | 自定义IV（可选，Base64编码，16字节）。GCM模式无需此参数 |  [optional] |
|**outputFormat** | [**OutputFormatEnum**](#OutputFormatEnum) | 输出格式：base64（默认）或hex |  [optional] |



## Enum: ModeEnum

| Name | Value |
|---- | -----|
| GCM | &quot;GCM&quot; |
| CBC | &quot;CBC&quot; |
| ECB | &quot;ECB&quot; |
| CTR | &quot;CTR&quot; |
| OFB | &quot;OFB&quot; |
| CFB | &quot;CFB&quot; |



## Enum: PaddingEnum

| Name | Value |
|---- | -----|
| PKCS7 | &quot;PKCS7&quot; |
| ZERO | &quot;ZERO&quot; |
| NONE | &quot;NONE&quot; |



## Enum: OutputFormatEnum

| Name | Value |
|---- | -----|
| BASE64 | &quot;base64&quot; |
| HEX | &quot;hex&quot; |



