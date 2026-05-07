---
name: android-activity-lifecycle-entrypoint
description: Set up UI entrypoint using AndroidX Activity Compose + lifecycle-runtime-ktx conventions in AndroidBase. Use when editing MainActivity/MainApplication UI bootstrap or lifecycle-driven state.
---

# Android Activity + Lifecycle Entrypoint Workflow
## Conventions in this repo
- Use `ComponentActivity` + `setContent { ... }` for Compose bootstrap.
- Use `enableEdgeToEdge()` and apply `WindowInsets.safeDrawing` via modifiers.
- Expose ViewModel state using `by viewModels()` and `collectAsState()` in Compose.

## Steps
1. In the Activity, call `enableEdgeToEdge()` before `setContent`.
2. Inside `setContent`, collect ViewModel `StateFlow` with `collectAsState()`.
3. Use collected state to drive navigation start destination.
4. Keep long-running work in ViewModels (`viewModelScope`), not in Activity/Composables.

