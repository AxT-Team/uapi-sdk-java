

# PostSearchAggregateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**query** | **String** | 搜索查询关键词，支持中英文 |  |
|**site** | **String** | 限制搜索特定网站，不需要 &#x60;site:&#x60; 前缀 |  [optional] |
|**filetype** | **String** | 限制文件类型，不需要 &#x60;filetype:&#x60; 前缀。支持 pdf、doc、docx、ppt、pptx、xls、xlsx、txt 等 |  [optional] |
|**fetchFull** | **Boolean** | 是否获取页面完整正文（会影响响应时间） |  [optional] |
|**sort** | [**SortEnum**](#SortEnum) | 排序方式 |  [optional] |
|**timeRange** | [**TimeRangeEnum**](#TimeRangeEnum) | 时间范围过滤 |  [optional] |



## Enum: SortEnum

| Name | Value |
|---- | -----|
| RELEVANCE | &quot;relevance&quot; |
| DATE | &quot;date&quot; |



## Enum: TimeRangeEnum

| Name | Value |
|---- | -----|
| DAY | &quot;day&quot; |
| WEEK | &quot;week&quot; |
| MONTH | &quot;month&quot; |
| YEAR | &quot;year&quot; |



