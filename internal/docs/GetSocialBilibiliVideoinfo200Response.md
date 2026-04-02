

# GetSocialBilibiliVideoinfo200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bvid** | **String** | 稿件的BV号。 |  [optional] |
|**aid** | **BigDecimal** | 稿件的AV号。 |  [optional] |
|**videos** | **BigDecimal** | 稿件分P总数。如果是单P视频，则为1。 |  [optional] |
|**tid** | **BigDecimal** | 视频所属的子分区 ID。 |  [optional] |
|**tname** | **String** | 视频所属的子分区名称。 |  [optional] |
|**copyright** | **BigDecimal** | 视频类型。1代表原创，2代表转载。 |  [optional] |
|**pic** | **String** | 稿件封面图片的URL。这是一个可以直接在网页上展示的链接。 |  [optional] |
|**title** | **String** | 稿件的标题。 |  [optional] |
|**pubdate** | **BigDecimal** | 稿件发布时间的Unix时间戳（秒）。 |  [optional] |
|**ctime** | **BigDecimal** | 用户投稿时间的Unix时间戳（秒）。 |  [optional] |
|**desc** | **String** | 视频简介。可能会包含HTML换行符。 |  [optional] |
|**descV2** | [**List&lt;GetSocialBilibiliVideoinfo200ResponseDescV2Inner&gt;**](GetSocialBilibiliVideoinfo200ResponseDescV2Inner.md) | 结构化简介片段。 |  [optional] |
|**state** | **BigDecimal** | 视频状态码。 |  [optional] |
|**duration** | **BigDecimal** | 稿件总时长（所有分P累加），单位为秒。 |  [optional] |
|**rights** | [**GetSocialBilibiliVideoinfo200ResponseRights**](GetSocialBilibiliVideoinfo200ResponseRights.md) |  |  [optional] |
|**owner** | [**GetSocialBilibiliVideoinfo200ResponseOwner**](GetSocialBilibiliVideoinfo200ResponseOwner.md) |  |  [optional] |
|**stat** | [**GetSocialBilibiliVideoinfo200ResponseStat**](GetSocialBilibiliVideoinfo200ResponseStat.md) |  |  [optional] |
|**dynamic** | **String** | 投稿时附带的动态文字。 |  [optional] |
|**cid** | **BigDecimal** | 主分P的 CID（弹幕 ID）。 |  [optional] |
|**dimension** | [**GetSocialBilibiliVideoinfo200ResponseDimension**](GetSocialBilibiliVideoinfo200ResponseDimension.md) |  |  [optional] |
|**noCache** | **Boolean** | 不缓存标记。 |  [optional] |
|**pages** | [**List&lt;GetSocialBilibiliVideoinfo200ResponsePagesInner&gt;**](GetSocialBilibiliVideoinfo200ResponsePagesInner.md) | 视频分P列表。即使是单P视频，该数组也包含一个元素。 |  [optional] |
|**subtitle** | [**GetSocialBilibiliVideoinfo200ResponseSubtitle**](GetSocialBilibiliVideoinfo200ResponseSubtitle.md) |  |  [optional] |
|**staff** | [**List&lt;GetSocialBilibiliVideoinfo200ResponseStaffInner&gt;**](GetSocialBilibiliVideoinfo200ResponseStaffInner.md) | 联合投稿成员列表。 |  [optional] |
|**ugcSeason** | [**GetSocialBilibiliVideoinfo200ResponseUgcSeason**](GetSocialBilibiliVideoinfo200ResponseUgcSeason.md) |  |  [optional] |
|**isChargeableSeason** | **Boolean** | 是否为付费合集。 |  [optional] |
|**isStory** | **Boolean** | 是否为剧情类视频。 |  [optional] |
|**honorReply** | [**GetSocialBilibiliVideoinfo200ResponseHonorReply**](GetSocialBilibiliVideoinfo200ResponseHonorReply.md) |  |  [optional] |



