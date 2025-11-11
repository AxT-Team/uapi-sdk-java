

# GetSocialBilibiliReplies200ResponseRepliesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**rpid** | **BigDecimal** | 评论的唯一ID (Reply ID)。 |  [optional] |
|**oid** | **BigDecimal** | 评论区对象ID，即视频的aid。 |  [optional] |
|**mid** | **BigDecimal** | 发表评论的用户的mid。 |  [optional] |
|**root** | **BigDecimal** | 根评论的rpid。如果为0，表示这条评论是根评论。 |  [optional] |
|**parent** | **BigDecimal** | 回复的父级评论的rpid。如果为0，表示是根评论。 |  [optional] |
|**count** | **BigDecimal** | 这条评论下的回复（楼中楼）数量。 |  [optional] |
|**ctime** | **BigDecimal** | 评论发送时间的Unix时间戳（秒）。 |  [optional] |
|**like** | **BigDecimal** | 该评论获得的点赞数。 |  [optional] |
|**member** | [**GetSocialBilibiliReplies200ResponseRepliesInnerMember**](GetSocialBilibiliReplies200ResponseRepliesInnerMember.md) |  |  [optional] |
|**content** | [**GetSocialBilibiliReplies200ResponseRepliesInnerContent**](GetSocialBilibiliReplies200ResponseRepliesInnerContent.md) |  |  [optional] |
|**replies** | **List&lt;Object&gt;** | 楼中楼回复列表。结构与顶层评论对象一致，但通常此数组为空，需要单独请求。 |  [optional] |



