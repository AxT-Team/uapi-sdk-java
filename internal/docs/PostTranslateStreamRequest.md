

# PostTranslateStreamRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**query** | **String** | 待翻译的文本内容 |  |
|**toLang** | [**ToLangEnum**](#ToLangEnum) | 目标语言，支持：中文、英文 |  |
|**fromLang** | [**FromLangEnum**](#FromLangEnum) | 源语言，支持：中文、英文、auto（自动检测）。默认为auto |  [optional] |
|**tone** | **String** | 语气参数，可选 |  [optional] |



## Enum: ToLangEnum

| Name | Value |
|---- | -----|
| u | &quot;中文&quot; |
| u2 | &quot;英文&quot; |



## Enum: FromLangEnum

| Name | Value |
|---- | -----|
| u | &quot;中文&quot; |
| u2 | &quot;英文&quot; |
| AUTO | &quot;auto&quot; |



