

# GetMiscLunartime200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**queryTimestamp** | **String** | 原始 ts 入参。 |  [optional] |
|**queryTimezone** | **String** | 原始 timezone 入参。 |  [optional] |
|**timezone** | **String** | 解析后的时区。 |  [optional] |
|**datetime** | **String** | 本地化时间，格式 YYYY-MM-DD HH:mm:ss。 |  [optional] |
|**datetimeRfc3339** | **String** | RFC3339 时间格式。 |  [optional] |
|**timestampUnix** | **Integer** | 秒级 Unix 时间戳。 |  [optional] |
|**weekday** | **String** | 星期英文。 |  [optional] |
|**weekdayCn** | **String** | 星期中文。 |  [optional] |
|**lunarYear** | **Integer** | 农历年份（数字）。 |  [optional] |
|**lunarMonth** | **Integer** | 农历月份（数字）。 |  [optional] |
|**lunarDay** | **Integer** | 农历日期（数字）。 |  [optional] |
|**isLeapMonth** | **Boolean** | 是否闰月。 |  [optional] |
|**lunarYearCn** | **String** | 农历年份中文表示。 |  [optional] |
|**lunarMonthCn** | **String** | 农历月份中文表示。 |  [optional] |
|**lunarDayCn** | **String** | 农历日期中文表示。 |  [optional] |
|**ganzhiYear** | **String** | 干支年。 |  [optional] |
|**ganzhiMonth** | **String** | 干支月。 |  [optional] |
|**ganzhiDay** | **String** | 干支日。 |  [optional] |
|**zodiac** | **String** | 生肖。 |  [optional] |
|**solarTerm** | **String** | 节气名称。有值时返回，无值时可能为空字符串或不返回。 |  [optional] |
|**lunarFestivals** | **List&lt;String&gt;** | 农历节日数组。 |  [optional] |
|**solarFestivals** | **List&lt;String&gt;** | 公历节日数组。 |  [optional] |



