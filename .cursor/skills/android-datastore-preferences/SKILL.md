---
name: android-datastore-preferences
description: Implement local key/value persistence using Jetpack DataStore preferences in AndroidBase. Use when adding new stored preferences or extending Auth/local storage behavior.
---

# Android DataStore Preferences Workflow
## Conventions
- `LocalStorageManager` is the single entry point for DataStore access.
- It uses `Context.dataStore` with `preferencesDataStore(name = DATA_STORE_NAME)`.
- Token is stored under a `stringPreferencesKey` constant.

## Steps
1. Extend `LocalStorageManager` with:
   - a `val someFlow: Flow<T?>` using `.data.map { preferences -> ... }`
   - `suspend fun saveX(value: T)` using `dataStore.edit { ... }`
   - `suspend fun clearX()` as needed
2. Expose these via `*LocalDataSource` classes for the repository layer to use.
3. Update repositories to call local datasource methods and map flows into UI state if required.

