---
name: android-lifecycle-helpers
description: Apply lifecycle-runtime-ktx patterns in AndroidBase for ViewModel coroutines and Compose state observation. Use when wiring ViewModel scope, StateFlow collection, and UI side effects.
---

# Android Lifecycle + State Observation Workflow
## Conventions
- Use `viewModelScope.launch { ... }` for async work.
- In Composables, observe `StateFlow` using `collectAsState()`.
- Use `LaunchedEffect(...)` for one-time or key-based side effects.

## Steps
1. In ViewModel: update UI state via `MutableStateFlow` and `State(isLoading=..., data=..., errorMessage=...)`.
2. In Composable: read state with `collectAsState()` and show UI based on `isLoading/errorMessage/data`.
3. If action is triggered by state transition (example: login success -> navigate), place it in `LaunchedEffect(state.data)`.

