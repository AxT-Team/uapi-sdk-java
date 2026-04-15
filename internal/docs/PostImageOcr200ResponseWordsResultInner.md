

# PostImageOcr200ResponseWordsResultInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**words** | **String** | 当前文字片段的识别结果。 |  [optional] |
|**location** | [**PostImageOcr200ResponseWordsResultInnerLocation**](PostImageOcr200ResponseWordsResultInnerLocation.md) |  |  [optional] |
|**vertexesLocation** | [**List&lt;PostImageOcr200ResponseWordsResultInnerVertexesLocationInner&gt;**](PostImageOcr200ResponseWordsResultInnerVertexesLocationInner.md) | 当前文字片段的顶点坐标列表。只有在 &#x60;need_location&#x3D;true&#x60; 时才会返回。 |  [optional] |
|**score** | **BigDecimal** | 当前文字片段的置信度。部分结果会返回。 |  [optional] |



