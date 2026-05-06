# AGENTS.md — uapi-sdk-java

This file tells AI coding agents how to use the **official Java SDK** for
the [uapis.cn](https://uapis.cn) public API platform.

## What this artifact is

Idiomatic Java client for UAPI. Generated from the live OpenAPI 3.1 spec at
<https://uapis.cn/openapi.json> — class names, method names, and parameter
shapes track the real API.

## Install

Maven (`pom.xml`):

```xml
<dependency>
  <groupId>cn.uapis</groupId>
  <artifactId>uapi-sdk-java</artifactId>
  <version>0.1.17</version>
</dependency>
```

Gradle (`build.gradle.kts`):

```kotlin
implementation("cn.uapis:uapi-sdk-java:0.1.17")
```

## Quick start

```java
import cn.uapis.UapiClient;
import cn.uapis.api.MiscApi;
import cn.uapis.model.GetMiscWeatherRequest;

UapiClient client = new UapiClient("https://uapis.cn");
MiscApi misc = new MiscApi(client);
var resp = misc.getMiscWeather(new GetMiscWeatherRequest().city("北京"));
System.out.println(resp);
```

The SDK is grouped by tag (`MiscApi`, `NetworkApi`, `TextApi`, `ImageApi`,
`SocialApi`, `TranslateApi`, `SearchApi`, …). Method names match the
OpenAPI `operationId`, camelCased.

## Authentication

Free-tier endpoints work with no key. Paid endpoints take a key:

```java
UapiClient client = new UapiClient("https://uapis.cn", "sk_…");
```

## Errors

Methods throw `UapiApiException` (subclass of `IOException`) on non-2xx
responses. The exception carries `code`, `error`, and `requestId` fields.
Surface `error` verbatim.

## Rate limits

Headers `X-RateLimit-Limit`, `X-RateLimit-Remaining`, `X-RateLimit-Reset`,
`Retry-After` are exposed on response headers. Honor them.

## Related repos

- MCP server: <https://github.com/AxT-Team/uapi-mcp>.
- Skills bundle: <https://github.com/AxT-Team/uapi-agent-skills>.
- Other languages: `uapi-sdk-typescript`, `uapi-sdk-python`, `uapi-sdk-go`,
  `uapi-sdk-rust`, `uapi-sdk-csharp`, `uapi-sdk-cpp`, `uapi-sdk-php`.
