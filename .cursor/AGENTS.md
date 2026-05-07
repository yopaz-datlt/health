# AndroidBase AI Conventions

Use this repository's existing patterns and do not invent new architecture.

## Project structure
- `app/presentation/*`: Jetpack Compose UI + navigation + ViewModels
- `app/domain/*`: domain models only
- `app/data/*`: remote/local datasources, repositories, Result/State mappings
- `base/*`: shared UI components (ex: `Loading`)

## Data flow contract
- Remote APIs return `retrofit2.Response<BaseResponse<T>>`
- Convert network responses to `Result<T>` using `ResponseExtensions.toResult()`
- ViewModels convert `Result<T>` to UI state via `ResultExtensions.toState()`, and expose `State<T>` to Composables

## Dependency injection
- Prefer Hilt everywhere (`@AndroidEntryPoint`, `@HiltViewModel`, `@HiltAndroidApp`)
- Retrofit/OkHttp wiring is centralized in `data/remote/apis/APIModule.kt`

When implementing a new feature, wire it end-to-end (API -> datasource -> repository -> ViewModel -> UI -> navigation) following the workflow in the Cursor skills.

