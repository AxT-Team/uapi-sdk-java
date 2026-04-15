

# GetGithubUser200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**login** | **String** | GitHub 登录名。 |  [optional] |
|**name** | **String** | 用户公开显示的名称。 |  [optional] |
|**bio** | **String** | 用户个人简介。 |  [optional] |
|**company** | **String** | 用户填写的公司或组织信息。 |  [optional] |
|**location** | **String** | 用户公开展示的地理位置。 |  [optional] |
|**blog** | **String** | 用户填写的网站或博客地址。 |  [optional] |
|**twitterUsername** | **String** | 用户绑定的 X（Twitter）用户名。 |  [optional] |
|**email** | **String** | 用户公开可见的邮箱地址。 |  [optional] |
|**htmlUrl** | **String** | GitHub 个人主页链接。 |  [optional] |
|**avatarUrl** | **String** | 用户头像图片链接。 |  [optional] |
|**type** | **String** | 账号类型，常见值为 User 或 Organization。 |  [optional] |
|**publicRepos** | **Integer** | 公开仓库数量。 |  [optional] |
|**publicGists** | **Integer** | 公开 Gist 数量。 |  [optional] |
|**followers** | **Integer** | 关注该用户的人数。 |  [optional] |
|**following** | **Integer** | 该用户正在关注的人数。 |  [optional] |
|**createdAt** | **OffsetDateTime** | GitHub 账号创建时间（ISO 8601）。 |  [optional] |
|**updatedAt** | **OffsetDateTime** | 用户资料最近更新时间（ISO 8601）。 |  [optional] |
|**organizations** | [**List&lt;GetGithubUser200ResponseOrganizationsInner&gt;**](GetGithubUser200ResponseOrganizationsInner.md) | 用户公开加入的组织列表 |  [optional] |
|**activity** | [**GetGithubUser200ResponseActivity**](GetGithubUser200ResponseActivity.md) |  |  [optional] |



