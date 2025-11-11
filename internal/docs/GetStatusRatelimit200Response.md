

# GetStatusRatelimit200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accepts** | **Integer** | Total number of accepted requests |  [optional] |
|**inFlight** | **Integer** | Number of current in-flight requests |  [optional] |
|**lastUpdate** | **String** | Last update time of the status |  [optional] |
|**limit** | **Integer** | Current concurrency limit |  [optional] |
|**load** | **BigDecimal** | Calculated system load (in_flight / limit) |  [optional] |
|**minRtt** | **BigDecimal** | Minimum observed RTT in milliseconds |  [optional] |
|**rejects** | **Integer** | Total number of rejected requests |  [optional] |
|**rtt** | **BigDecimal** | Smoothed RTT in milliseconds |  [optional] |
|**throttled** | **Integer** | Total number of throttled requests |  [optional] |



