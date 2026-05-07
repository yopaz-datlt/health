---
name: android-data-fetch
description: Implement a new data flow in AndroidBase (RemoteDataSource + Repository + optional Local caching) using the project's Result/State contracts. Use when the user asks for Repository/datasource code, data fetching logic, or error handling for network/local calls.
---

# Android Data Fetch Workflow
## Use the existing contracts
- Remote APIs: `Response<BaseResponse<T>>`
- Convert network responses: `ResponseExtensions.toResult()`
- UI state mapping: `ResultExtensions.toState()` to `presentation/common/State<T>`

## Steps to implement
1. Decide the return type:
   - Data-layer API should return `Result<T>` for one-shot calls.
   - Local datasources can expose `Flow<...>` and `suspend` save/delete methods.
2. Remote layer (if needed):
   - Add/update Retrofit endpoint in `data/remote/apis/*Api.kt` returning `Response<BaseResponse<T>>`.
   - Create/extend `*RemoteDataSource` in `data/remote/datasource/` as a thin wrapper around the API call.
3. Local layer (if needed):
   - Create/extend `*LocalDataSource` in `data/local/datasource/`.
   - Prefer `Flow<...>` for query/observation and `suspend` for persistence.
4. Repository (orchestrate):
   - Create/update `app/data/repositories/*Repository.kt`.
   - Implement a public `suspend fun ...(): Result<DomainModel>` that calls remote/local.
   - Convert Retrofit responses with `.toResult()` (do not re-implement parsing).
   - When caching, read local first and then fetch remote; on success, persist to local.
5. ViewModel wiring (UI layer):
   - Add a `MutableStateFlow(State<T>())` and expose `StateFlow`.
   - In `viewModelScope.launch`, set `State(isLoading = true)` and then assign `repositoryResult.toState()`.

