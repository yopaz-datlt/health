---
name: android-compose-navigation
description: Implement navigation using Jetpack Compose Navigation patterns already used in AndroidBase (AppDestinations/AppNavHost + auth flow). Use when adding new routes or wiring navigation from Composables.
---

# Android Compose Navigation Workflow
## Conventions
- Routes are defined as string constants in `app/presentation/navigation/AppNavigation.kt` (`AppDestinations`).
- Destination registration happens only inside `AppNavHost`.
- For ViewModels in screens, prefer Hilt integration:
  - Composable screens: `hiltViewModel()` or `hiltViewModel()` inside destination blocks.

## Steps
1. Add route constant in `AppDestinations`.
2. Register `composable(AppDestinations.X)` inside `AppNavHost`.
3. Create/Update the screen Composable to call callbacks for navigation events.
4. For auth-related transitions, use `popUpTo(...){ inclusive = true }` when replacing the back stack.

