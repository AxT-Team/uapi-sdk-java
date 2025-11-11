

# GetSocialBilibiliLiveroom200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**uid** | **BigDecimal** | 主播的用户ID (mid)。 |  [optional] |
|**roomId** | **BigDecimal** | 直播间的真实房间号（长号）。 |  [optional] |
|**shortId** | **BigDecimal** | 直播间的短号（靓号）。如果没有设置，则为0。 |  [optional] |
|**attention** | **BigDecimal** | 主播的粉丝数（关注数量）。 |  [optional] |
|**online** | **BigDecimal** | 直播间当前的人气值。注意这不是真实在线人数。 |  [optional] |
|**liveStatus** | **BigDecimal** | 直播状态。0:未开播, 1:直播中, 2:轮播中。 |  [optional] |
|**areaId** | **BigDecimal** | 分区ID。 |  [optional] |
|**parentAreaName** | **String** | 父分区名称。 |  [optional] |
|**areaName** | **String** | 子分区名称。 |  [optional] |
|**background** | **String** | 直播间背景图的URL。 |  [optional] |
|**title** | **String** | 当前直播间的标题。 |  [optional] |
|**userCover** | **String** | 用户设置的直播间封面URL。 |  [optional] |
|**description** | **String** | 直播间公告或描述，支持换行符。 |  [optional] |
|**liveTime** | **String** | 本次直播开始的时间，格式为 &#x60;YYYY-MM-DD HH:mm:ss&#x60;。如果未开播，则为空字符串。 |  [optional] |
|**tags** | **String** | 直播间设置的标签，以逗号分隔。 |  [optional] |
|**hotWords** | **List&lt;String&gt;** | 直播间热词列表，通常用于弹幕互动。 |  [optional] |
|**newPendants** | **Object** | 主播佩戴的头像框、大航海等级等信息，结构可能比较复杂。 |  [optional] |



