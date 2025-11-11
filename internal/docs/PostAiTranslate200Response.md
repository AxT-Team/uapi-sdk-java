

# PostAiTranslate200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **Integer** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**isBatch** | **Boolean** | 标识是否为批量翻译请求。 |  [optional] |
|**data** | [**PostAiTranslate200ResponseData**](PostAiTranslate200ResponseData.md) |  |  [optional] |
|**batchData** | [**List&lt;PostAiTranslate200ResponseBatchDataInner&gt;**](PostAiTranslate200ResponseBatchDataInner.md) | 批量翻译结果列表，仅在批量翻译时返回。 |  [optional] |
|**batchSummary** | [**PostAiTranslate200ResponseBatchSummary**](PostAiTranslate200ResponseBatchSummary.md) |  |  [optional] |
|**performance** | [**PostAiTranslate200ResponsePerformance**](PostAiTranslate200ResponsePerformance.md) |  |  [optional] |
|**qualityMetrics** | [**PostAiTranslate200ResponseQualityMetrics**](PostAiTranslate200ResponseQualityMetrics.md) |  |  [optional] |



