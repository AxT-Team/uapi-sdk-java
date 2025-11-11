

# PostAiTranslateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**text** | **String** | 单个翻译时使用的待翻译文本，与texts参数二选一。最大长度10,000字符。 |  [optional] |
|**texts** | **List&lt;String&gt;** | 批量翻译时使用的待翻译文本列表，与text参数二选一。最多50条，总计最大100,000字符。 |  [optional] |
|**sourceLang** | **String** | 源语言代码，可选。如果不指定，系统会自动检测源语言。 |  [optional] |
|**style** | [**StyleEnum**](#StyleEnum) | 翻译风格，可选。支持casual(随意口语化)、professional(专业商务，默认)、academic(学术正式)、literary(文学艺术)。 |  [optional] |
|**context** | [**ContextEnum**](#ContextEnum) | 翻译上下文场景，可选。支持general(通用，默认)、business(商务)、technical(技术)、medical(医疗)、legal(法律)、marketing(市场营销)、entertainment(娱乐)、education(教育)、news(新闻)。 |  [optional] |
|**preserveFormat** | **Boolean** | 是否保留原文格式，包括换行、缩进等。 |  [optional] |
|**fastMode** | **Boolean** | 是否启用快速模式。快速模式响应时间约800ms，准确率95%+；普通模式响应时间约2000ms，准确率98%+。 |  [optional] |
|**maxConcurrency** | **Integer** | 批量翻译时的最大并发数，范围1-10。仅在批量翻译时有效。 |  [optional] |



## Enum: StyleEnum

| Name | Value |
|---- | -----|
| CASUAL | &quot;casual&quot; |
| PROFESSIONAL | &quot;professional&quot; |
| ACADEMIC | &quot;academic&quot; |
| LITERARY | &quot;literary&quot; |



## Enum: ContextEnum

| Name | Value |
|---- | -----|
| GENERAL | &quot;general&quot; |
| BUSINESS | &quot;business&quot; |
| TECHNICAL | &quot;technical&quot; |
| MEDICAL | &quot;medical&quot; |
| LEGAL | &quot;legal&quot; |
| MARKETING | &quot;marketing&quot; |
| ENTERTAINMENT | &quot;entertainment&quot; |
| EDUCATION | &quot;education&quot; |
| NEWS | &quot;news&quot; |



