

# GetMiscHotboard200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** |  |  [optional] |
|**updateTime** | **String** | 热榜更新时间。时光机无匹配快照时可能为空字符串。 |  [optional] |
|**snapshotTime** | **Integer** | 时光机模式返回的快照实际时间戳（毫秒）。当前热榜模式下通常不返回。 |  [optional] |
|**_list** | [**List&lt;GetMiscHotboard200ResponseOneOfListInner&gt;**](GetMiscHotboard200ResponseOneOfListInner.md) | 热榜条目列表。 |  [optional] |
|**keyword** | **String** | 搜索关键词。 |  [optional] |
|**count** | **Integer** | 匹配到的结果数量。 |  [optional] |
|**results** | [**List&lt;GetMiscHotboard200ResponseOneOf1ResultsInner&gt;**](GetMiscHotboard200ResponseOneOf1ResultsInner.md) | 搜索结果数组。 |  [optional] |



