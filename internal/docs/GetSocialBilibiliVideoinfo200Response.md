

# GetSocialBilibiliVideoinfo200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bvid** | **String** | 稿件的BV号。 |  [optional] |
|**aid** | **BigDecimal** | 稿件的AV号。 |  [optional] |
|**videos** | **BigDecimal** | 稿件分P总数。如果是单P视频，则为1。 |  [optional] |
|**tname** | **String** | 视频所属的子分区名称。 |  [optional] |
|**copyright** | **BigDecimal** | 视频类型。1代表原创，2代表转载。 |  [optional] |
|**pic** | **String** | 稿件封面图片的URL。这是一个可以直接在网页上展示的链接。 |  [optional] |
|**title** | **String** | 稿件的标题。 |  [optional] |
|**pubdate** | **BigDecimal** | 稿件发布时间的Unix时间戳（秒）。 |  [optional] |
|**ctime** | **BigDecimal** | 用户投稿时间的Unix时间戳（秒）。 |  [optional] |
|**desc** | **String** | 视频简介。可能会包含HTML换行符。 |  [optional] |
|**duration** | **BigDecimal** | 稿件总时长（所有分P累加），单位为秒。 |  [optional] |
|**owner** | [**GetSocialBilibiliVideoinfo200ResponseOwner**](GetSocialBilibiliVideoinfo200ResponseOwner.md) |  |  [optional] |
|**stat** | [**GetSocialBilibiliVideoinfo200ResponseStat**](GetSocialBilibiliVideoinfo200ResponseStat.md) |  |  [optional] |
|**pages** | [**List&lt;GetSocialBilibiliVideoinfo200ResponsePagesInner&gt;**](GetSocialBilibiliVideoinfo200ResponsePagesInner.md) | 视频分P列表。即使是单P视频，该数组也包含一个元素。 |  [optional] |



