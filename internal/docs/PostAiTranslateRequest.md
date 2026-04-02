

# PostAiTranslateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**text** | **String** | 待翻译的文本内容。最大长度10,000字符。 |  |
|**sourceLang** | **String** | 源语言代码，可选。如果不指定，系统会自动检测源语言。 |  [optional] |
|**style** | [**StyleEnum**](#StyleEnum) | 翻译风格，可选。支持casual(随意口语化)、professional(专业商务，默认)、academic(学术正式)、literary(文学艺术)。 |  [optional] |
|**context** | [**ContextEnum**](#ContextEnum) | 翻译上下文场景，可选。支持general(通用，默认)、business(商务)、technical(技术)、medical(医疗)、legal(法律)、marketing(市场营销)、entertainment(娱乐)、education(教育)、news(新闻)。 |  [optional] |
|**preserveFormat** | **Boolean** | 是否保留原文格式，包括换行、缩进等。 |  [optional] |



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



