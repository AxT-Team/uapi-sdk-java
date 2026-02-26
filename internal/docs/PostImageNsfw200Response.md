

# PostImageNsfw200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nsfwScore** | **BigDecimal** | NSFW 内容的置信度分数，范围 0-1，越高表示越可能是敏感内容。 |  [optional] |
|**normalScore** | **BigDecimal** | 正常内容的置信度分数，范围 0-1。 |  [optional] |
|**isNsfw** | **Boolean** | 是否判定为 NSFW 内容。 |  [optional] |
|**label** | **String** | 内容标签，&#39;nsfw&#39; 或 &#39;normal&#39;。 |  [optional] |
|**suggestion** | **String** | 处理建议：&#39;pass&#39;（通过）、&#39;review&#39;（人工复核）、&#39;block&#39;（拦截）。 |  [optional] |
|**riskLevel** | **String** | 风险等级：&#39;low&#39;、&#39;medium&#39;、&#39;high&#39;。 |  [optional] |
|**confidence** | **BigDecimal** | 模型对当前判断的置信度。 |  [optional] |
|**inferenceTimeMs** | **BigDecimal** | 模型推理耗时，单位毫秒。 |  [optional] |



