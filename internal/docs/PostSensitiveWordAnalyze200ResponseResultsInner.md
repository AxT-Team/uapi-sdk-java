

# PostSensitiveWordAnalyze200ResponseResultsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**k** | **String** |  |  [optional] |
|**label** | [**LabelEnum**](#LabelEnum) |  |  [optional] |
|**category** | [**CategoryEnum**](#CategoryEnum) |  |  [optional] |
|**confidence** | **BigDecimal** |  |  [optional] |



## Enum: LabelEnum

| Name | Value |
|---- | -----|
| SENSITIVE | &quot;sensitive&quot; |
| NORMAL | &quot;normal&quot; |



## Enum: CategoryEnum

| Name | Value |
|---- | -----|
| SAFE | &quot;safe&quot; |
| THREAT | &quot;threat&quot; |
| PORN | &quot;porn&quot; |
| FRAUD | &quot;fraud&quot; |
| INSULT | &quot;insult&quot; |



