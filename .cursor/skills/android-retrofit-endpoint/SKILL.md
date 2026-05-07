---
name: android-retrofit-endpoint
description: Add a new Retrofit/OkHttp endpoint into AndroidBase (API interface + models + wiring in APIModule) following existing networking conventions. Use when the user asks to create an endpoint, extend APIModule/Retrofit wiring, or implement a new request/response model for network calls.
---

# Android Retrofit Endpoint Workflow
## Steps
1. Create/update network models:
   - Requests: add a `*Request` in `data/remote/apis/models/requests` and annotate with `@JsonClass(generateAdapter = true)` when serializable.
   - Responses payload (domain): add domain models under `app/domain/models/` with `@JsonClass` (or map from entities) as needed.
2. Update the Retrofit API interface:
   - Add the new method in `data/remote/apis/*Api.kt`.
   - Return `Response<BaseResponse<T>>` where `BaseResponse<T>` is the envelope already used by the project.
3. Wire the API into Hilt:
   - If it's a new `*Api` interface, update `data/remote/apis/APIModule.kt` with a `provideXApi()` method.
   - Do not duplicate OkHttp/Retrofit setup; keep it centralized in `APIModule`.
4. Ensure auth behavior:
   - Authorization token and JSON headers are handled by `AppInterceptor`.
   - Prefer updating `AppInterceptor` only for cross-cutting auth/header changes.
5. Provide a RemoteDataSource wrapper:
   - Create/extend `*RemoteDataSource` in `data/remote/datasource/` to call the API.

