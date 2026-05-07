---
name: androidx-appcompat-browser
description: Use AndroidX AppCompat and Browser conventions in AndroidBase when needing UI theming or opening external URLs. Use when adding menu/theme support or launching browser for a link.
---

# AndroidX AppCompat + Browser Workflow
## Conventions
- Theme/app compatibility are handled by the Android manifest and standard styles.
- When opening external URLs, prefer using the AndroidX Browser API rather than launching custom WebViews unless you have a strong reason.

## Steps
1. Use resources/styles for any UI theming work (do not hardcode theme values in Compose).
2. For external links, create a click handler in the UI layer that triggers an intent using AndroidX `Browser`.
3. Keep URL opening logic out of Composables where possible (use callbacks).

