

# PostTextMarkdownToPdfRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**text** | **String** | 原始 Markdown 字符串，最大不超过 1MB。 |  |
|**theme** | [**ThemeEnum**](#ThemeEnum) | PDF 的排版主题。可选 &#x60;github&#x60;、&#x60;minimal&#x60;、&#x60;light&#x60;、&#x60;dark&#x60;，默认是 &#x60;github&#x60;。 |  [optional] |
|**paperSize** | [**PaperSizeEnum**](#PaperSizeEnum) | PDF 的纸张大小。可选 &#x60;A4&#x60; 或 &#x60;Letter&#x60;，默认是 &#x60;A4&#x60;。 |  [optional] |



## Enum: ThemeEnum

| Name | Value |
|---- | -----|
| GITHUB | &quot;github&quot; |
| MINIMAL | &quot;minimal&quot; |
| LIGHT | &quot;light&quot; |
| DARK | &quot;dark&quot; |



## Enum: PaperSizeEnum

| Name | Value |
|---- | -----|
| A4 | &quot;A4&quot; |
| LETTER | &quot;Letter&quot; |



