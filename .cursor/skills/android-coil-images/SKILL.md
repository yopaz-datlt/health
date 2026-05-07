---
name: android-coil-images
description: Use Coil Image loading in AndroidBase Compose UI. Use when displaying remote images (avatars/icons) inside Composables.
---

# Android Coil Images Workflow
## Conventions
- Use `coil.compose.AsyncImage` in Composables.
- For decorative images, prefer `contentDescription = null`.
- Common usage in the project:
  - `modifier.size(...).clip(...)`
  - choose `contentScale` (e.g. `Fit`/`Crop`) to match design.

## Steps
1. Pass image URL (String) to the Composable as part of model/UI state.
2. Render with `AsyncImage(model = url, ...)`.
3. Apply `Modifier` (size/clip) and select `contentScale` based on layout.

