

# GetGithubUser200ResponseActivity

贡献活动数据（需开启 activity=true）

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**scope** | **String** | 活动统计范围，常见值为 all 或 organization。 |  [optional] |
|**organization** | **String** | 按组织过滤时对应的组织登录名。 |  [optional] |
|**from** | **String** | 统计开始日期。 |  [optional] |
|**to** | **String** | 统计结束日期。 |  [optional] |
|**totalContributions** | **Integer** | 统计范围内的总贡献数。 |  [optional] |
|**totalCommitContributions** | **Integer** | Commit 贡献总数。 |  [optional] |
|**totalIssueContributions** | **Integer** | Issue 贡献总数。 |  [optional] |
|**totalPullRequestContributions** | **Integer** | Pull Request 贡献总数。 |  [optional] |
|**totalPullRequestReviewContributions** | **Integer** | Pull Request Review 贡献总数。 |  [optional] |
|**contributionCalendar** | [**GetGithubUser200ResponseActivityContributionCalendar**](GetGithubUser200ResponseActivityContributionCalendar.md) |  |  [optional] |
|**timeline** | [**List&lt;GetGithubUser200ResponseActivityTimelineInner&gt;**](GetGithubUser200ResponseActivityTimelineInner.md) | 按月份聚合后的贡献时间线。 |  [optional] |



