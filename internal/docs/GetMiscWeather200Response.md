

# GetMiscWeather200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**province** | **String** | 省份 |  [optional] |
|**city** | **String** | 城市名 |  [optional] |
|**adcode** | **String** | 行政区划代码（部分数据源可能为空） |  [optional] |
|**weather** | **String** | 天气状况描述。默认返回中文，传 &#x60;lang&#x3D;en&#x60; 时返回英文。非固定枚举。 |  [optional] |
|**temperature** | **BigDecimal** | 当前温度 °C |  [optional] |
|**windDirection** | **String** | 风向 |  [optional] |
|**windPower** | **String** | 风力等级 |  [optional] |
|**humidity** | **BigDecimal** | 相对湿度 % |  [optional] |
|**reportTime** | **String** | 数据更新时间 |  [optional] |
|**feelsLike** | **BigDecimal** | 体感温度 °C（extended&#x3D;true 时返回） |  [optional] |
|**visibility** | **BigDecimal** | 能见度 km（extended&#x3D;true 时返回） |  [optional] |
|**pressure** | **BigDecimal** | 气压 hPa（extended&#x3D;true 时返回） |  [optional] |
|**uv** | **BigDecimal** | 紫外线指数（extended&#x3D;true 时返回） |  [optional] |
|**precipitation** | **BigDecimal** | 当前降水量 mm（extended&#x3D;true 时返回） |  [optional] |
|**cloud** | **BigDecimal** | 云量 %（extended&#x3D;true 时返回） |  [optional] |
|**aqi** | **BigDecimal** | 空气质量指数 0-500（extended&#x3D;true 时返回） |  [optional] |
|**aqiLevel** | **BigDecimal** | AQI 等级 1-6（extended&#x3D;true 时返回） |  [optional] |
|**aqiCategory** | **String** | AQI 等级描述（优/良/轻度污染/中度污染/重度污染/严重污染）（extended&#x3D;true 时返回） |  [optional] |
|**aqiPrimary** | **String** | 主要污染物（如 PM2.5、PM10、O3 等）（extended&#x3D;true 时返回） |  [optional] |
|**airPollutants** | [**GetMiscWeather200ResponseAirPollutants**](GetMiscWeather200ResponseAirPollutants.md) |  |  [optional] |
|**tempMax** | **BigDecimal** | 当天最高温 °C（forecast&#x3D;true 时返回） |  [optional] |
|**tempMin** | **BigDecimal** | 当天最低温 °C（forecast&#x3D;true 时返回） |  [optional] |
|**forecast** | [**List&lt;GetMiscWeather200ResponseForecastInner&gt;**](GetMiscWeather200ResponseForecastInner.md) | 多天天气预报，最多7天（forecast&#x3D;true 时返回） |  [optional] |
|**hourlyForecast** | [**List&lt;GetMiscWeather200ResponseHourlyForecastInner&gt;**](GetMiscWeather200ResponseHourlyForecastInner.md) | 逐小时预报，最多24小时（hourly&#x3D;true 时返回） |  [optional] |
|**minutelyPrecip** | [**GetMiscWeather200ResponseMinutelyPrecip**](GetMiscWeather200ResponseMinutelyPrecip.md) |  |  [optional] |
|**lifeIndices** | [**GetMiscWeather200ResponseLifeIndices**](GetMiscWeather200ResponseLifeIndices.md) |  |  [optional] |



