

# GetMiscHolidayCalendar200ResponseDataHolidaysInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**date** | **String** | 事件日期（YYYY-MM-DD）。 |  [optional] |
|**name** | **String** | 事件名称。 |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | 事件类型。 |  [optional] |
|**isWorkday** | **Boolean** | 仅 legal_workday_adjust 场景有意义。 |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| LEGAL_REST | &quot;legal_rest&quot; |
| LEGAL_WORKDAY_ADJUST | &quot;legal_workday_adjust&quot; |
| SOLAR_FESTIVAL | &quot;solar_festival&quot; |
| LUNAR_FESTIVAL | &quot;lunar_festival&quot; |
| SOLAR_TERM | &quot;solar_term&quot; |



