---
name: android-spinkit-loading
description: Implement loading spinners in AndroidBase using Spinkit. Use when adding non-blocking progress indicators in Compose.
---

# Android Spinkit Loading Workflow
## Conventions in this repo
- The project wraps a spinner inside the shared `Loading()` Composable:
  - `com.kira.android_base.base.components.Loading`
  - It uses `AndroidView` + `ProgressBar` with a `Circle()` drawable.

## Steps
1. Prefer using the existing `Loading()` Composable instead of re-implementing.
2. If a new spinner style is needed, create it inside `base/components/` and keep it reusable.

