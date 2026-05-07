---
name: android-add-screen
description: Generate and wire a new Jetpack Compose screen (UI + ViewModel + navigation) following AndroidBase conventions. Use when the user asks to add/implement a new screen, a navigation destination, or connect UI events to a Hilt ViewModel.
---

# Android Add Screen Workflow
## When implementing a screen
1. Identify the feature folder: create under `app/presentation/screens/<feature>/`.
2. Add/update navigation:
   - Add route constants in `presentation/navigation/AppNavigation.kt` (`AppDestinations`).
   - Register the screen inside `AppNavHost` via `composable(AppDestinations.<X>)`.
3. Create the UI Composable:
   - Put it in `*Screen.kt` under the feature package.
   - Use parameters for state and events (hoist state whenever possible).
   - Use `hiltViewModel()` for the ViewModel parameter when appropriate.
4. Create the ViewModel (Hilt):
   - Annotate with `@HiltViewModel`.
   - Inject required repositories via constructor.
   - Expose UI state as `StateFlow<State<T>>` using `MutableStateFlow(State<T>())`.
   - On events, set `State(isLoading = true)` then update with `repositoryResult.toState()`.
5. Wire state to UI:
   - Use `collectAsState()` to read `StateFlow` inside the Composable.
   - Show `Loading()` when `state.isLoading`.
   - Show `state.errorMessage` when non-null.
6. Side effects and navigation:
   - For one-time effects (ex: after login success), use `LaunchedEffect(state.data)` and call the provided callback.

