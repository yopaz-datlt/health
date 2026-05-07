---
name: android-chucker
description: Add/adjust Chucker debugging integration for OkHttp in AndroidBase. Use when needing to inspect network requests/responses during development.
---

# Android Chucker Workflow
## Conventions in this repo
- Chucker wiring is centralized in `app/data/remote/apis/APIModule.kt`.
- `ChuckerCollector` is created in `provideOkHttp()` and attached to `ChuckerInterceptor`.
- Request/response size is bounded using `maxContentLength`.

## Steps
1. Update `APIModule.provideOkHttp()` to adjust:
   - collector retention period
   - redaction headers
   - max content length
2. Keep auth/content handling in `AppInterceptor`, not in Chucker.

