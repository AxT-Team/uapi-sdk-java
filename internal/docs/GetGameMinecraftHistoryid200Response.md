

# GetGameMinecraftHistoryid200Response

响应结构根据查询参数不同而变化

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**query** | **String** | 【name 查询时返回】查询的用户名。 |  [optional] |
|**count** | **Integer** | 【name 查询时返回】匹配到的用户数量，为 0 时表示未找到。 |  [optional] |
|**results** | [**List&lt;GetGameMinecraftHistoryid200ResponseResultsInner&gt;**](GetGameMinecraftHistoryid200ResponseResultsInner.md) | 【name 查询时返回】匹配用户列表，包含当前用户名或曾用名匹配的所有玩家。 |  [optional] |
|**id** | **String** | 【uuid 查询时返回】玩家当前的用户名。 |  [optional] |
|**uuid** | **String** | 【uuid 查询时返回】被查询玩家的UUID（带连字符格式）。 |  [optional] |
|**nameNum** | **Integer** | 【uuid 查询时返回】历史名称的总数（包含当前名称）。 |  [optional] |
|**history** | [**List&lt;GetGameMinecraftHistoryid200ResponseHistoryInner&gt;**](GetGameMinecraftHistoryid200ResponseHistoryInner.md) | 【uuid 查询时返回】包含所有历史用户名的数组，按时间倒序排列。 |  [optional] |



