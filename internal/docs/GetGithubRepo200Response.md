

# GetGithubRepo200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fullName** | **String** | 仓库完整名称。 |  [optional] |
|**description** | **String** | 仓库简介。 |  [optional] |
|**homepage** | **String** | 仓库主页链接。 |  [optional] |
|**defaultBranch** | **String** | 默认分支名称。 |  [optional] |
|**primaryBranch** | **String** | 主要分支名称（通常与默认分支一致）。 |  [optional] |
|**defaultBranchSha** | **String** | 默认分支最新提交的 SHA 哈希。 |  [optional] |
|**visibility** | **String** | 仓库可见性，常见值为 &#x60;public&#x60; 或 &#x60;private&#x60;。 |  [optional] |
|**archived** | **Boolean** | 仓库是否已归档。 |  [optional] |
|**disabled** | **Boolean** | 仓库是否被禁用。 |  [optional] |
|**fork** | **Boolean** | 是否为 Fork 仓库。 |  [optional] |
|**language** | **String** | 主要语言。 |  [optional] |
|**topics** | **List&lt;String&gt;** | 话题标签列表。 |  [optional] |
|**license** | **String** | 开源许可证名称。 |  [optional] |
|**stargazers** | **Integer** | Star 数。 |  [optional] |
|**forks** | **Integer** | Fork 数。 |  [optional] |
|**openIssues** | **Integer** | 开放 Issue 数。 |  [optional] |
|**watchers** | **Integer** | 关注者数量（watchers/subscribers）。 |  [optional] |
|**pushedAt** | **OffsetDateTime** | 最后推送时间（ISO 8601）。 |  [optional] |
|**createdAt** | **OffsetDateTime** | 创建时间（ISO 8601）。 |  [optional] |
|**updatedAt** | **OffsetDateTime** | 更新时间（ISO 8601）。 |  [optional] |
|**languages** | **Map&lt;String, Integer&gt;** | 语言统计（键为语言名，值为代码字节数）。 |  [optional] |
|**collaborators** | [**List&lt;GetGithubRepo200ResponseCollaboratorsInner&gt;**](GetGithubRepo200ResponseCollaboratorsInner.md) | 协作者列表。受权限限制时可能为 null 或空数组。 |  [optional] |
|**maintainers** | [**List&lt;GetGithubRepo200ResponseCollaboratorsInner&gt;**](GetGithubRepo200ResponseCollaboratorsInner.md) | 维护者列表（根据默认分支近期提交推断）。 |  [optional] |
|**latestRelease** | [**GetGithubRepo200ResponseLatestRelease**](GetGithubRepo200ResponseLatestRelease.md) |  |  [optional] |



