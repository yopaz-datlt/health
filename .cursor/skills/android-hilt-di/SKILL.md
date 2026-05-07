---
name: android-hilt-di
description: Use Hilt dependency injection conventions in AndroidBase when wiring new dependencies or adding Hilt modules for APIs/DAOs/managers. Use when implementing injection failures, adding new services, or extending `data/*` modules.
---

# Android Hilt DI Workflow
## Conventions to follow
- Use constructor injection for classes that need dependencies (`@Inject constructor(...)`).
- Use `@HiltViewModel` for ViewModels created by Hilt.
- Use `@AndroidEntryPoint` for Android components that require injection.
- Centralize wiring in Hilt modules under `app/data/**`:
  - `data/remote/apis/APIModule.kt` for Retrofit/OkHttp/Moshi + API interfaces
  - `data/local/db/DatabaseModule.kt` for Room database + DAOs
  - `data/local/localstorage/LocalStorageModule.kt` for DataStore-backed managers

## When adding a new dependency
1. Create the implementation class in the most appropriate layer (`data/`, `base/`, etc.).
2. Decide the scope:
   - Prefer `@Singleton` for long-lived single instances.
3. If the dependency needs external frameworks (Retrofit, Room, DataStore), add a provider in an existing module rather than creating a new random module.
4. Update call sites to inject via constructor (avoid manual `new`).

