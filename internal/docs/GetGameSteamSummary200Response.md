

# GetGameSteamSummary200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**avatar** | **String** | 32x32 像素的小尺寸头像URL。 |  [optional] |
|**avatarfull** | **String** | 184x184 像素的大尺寸头像URL。 |  [optional] |
|**avatarmedium** | **String** | 64x64 像素的中等尺寸头像URL。 |  [optional] |
|**code** | **Integer** | 状态码，200代表成功。 |  [optional] |
|**communityvisibilitystate** | **Integer** | 社区资料的可见性状态: 1&#x3D;私密, 3&#x3D;公开。 |  [optional] |
|**loccountrycode** | **String** | 用户个人资料中设置的国家代码 (ISO 3166-1)，前提是用户已设置并公开。 |  [optional] |
|**personaname** | **String** | 玩家的当前昵称。 |  [optional] |
|**personastate** | **Integer** | 用户当前的在线状态: 0-离线, 1-在线, 2-忙碌, 3-离开, 4-打盹, 5-想交易, 6-想玩。 |  [optional] |
|**primaryclanid** | **String** | 玩家设置的主要部落的64位ID。 |  [optional] |
|**profilestate** | **Integer** | 如果用户设置了个人资料，则为1。 |  [optional] |
|**profileurl** | **String** | 用户的Steam社区个人资料页完整URL。 |  [optional] |
|**realname** | **String** | 用户的真实姓名，前提是用户已设置并公开。 |  [optional] |
|**steamid** | **String** | 被查询用户的64位SteamID。 |  [optional] |
|**timecreated** | **Integer** | 账户创建时的Unix时间戳（秒）。 |  [optional] |
|**timecreatedStr** | **String** | 我们为你格式化好的账户创建时间，更直观。 |  [optional] |



