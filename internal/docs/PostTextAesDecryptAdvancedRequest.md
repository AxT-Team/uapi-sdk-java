

# PostTextAesDecryptAdvancedRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**text** | **String** | 待解密的密文（Base64编码）。此值来自加密接口返回的ciphertext字段 |  |
|**key** | **String** | 解密密钥（必须与加密时相同） |  |
|**mode** | [**ModeEnum**](#ModeEnum) | 加密模式（必须与加密时相同）：GCM/CBC/ECB/CTR/OFB/CFB |  |
|**padding** | [**PaddingEnum**](#PaddingEnum) | 填充方式（可选，必须与加密时相同）：PKCS7/ZERO/NONE。GCM模式默认为NONE |  [optional] |
|**iv** | **String** | 初始化向量（非GCM模式必须提供，Base64编码）。此值来自加密接口返回的iv字段 |  [optional] |



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



