---
name: android-retrofit-okhttp-moshi
description: Add or extend network calls in AndroidBase using Retrofit + OkHttp + Moshi + BaseResponse/Result mapping. Use when creating endpoints, remote models, or troubleshooting API request/response handling.
---

# Android Retrofit + OkHttp + Moshi Workflow
## Core contracts (use these)
- Retrofit methods return `retrofit2.Response<BaseResponse<T>>`.
- Convert responses using `ResponseExtensions.toResult()` (do not hand-parse errors).
- Keep auth and JSON headers in `AppInterceptor`.

## Steps
1. Add/extend endpoint in `app/data/remote/apis/*Api.kt`:
   - Return `Response<BaseResponse<T>>`
   - Use Moshi-compatible request/response models.
2. If the endpoint is a new API interface, register it in `app/data/remote/apis/APIModule.kt` with a `provideXApi()` method.
3. Add a `*RemoteDataSource` wrapper under `app/data/remote/datasource/`:
   - Thin wrapper that calls the API method.
4. Update Repository:
   - Call remote datasource and map using `.toResult()`

## Notes
- `BuildConfig.BASE_URL` comes from your product flavors.
- Avoid changing OkHttp setup in multiple places; keep wiring inside `APIModule.kt`.

