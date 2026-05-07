---
name: android-firebase-analytics-crashlytics
description: Follow Firebase Analytics and Crashlytics conventions in AndroidBase. Use when adding analytics events or recording crashes.
---

# Android Firebase Analytics + Crashlytics Workflow
## Conventions
- Firebase dependencies are already present via Gradle.
- Crashlytics is configured in release build (mapping file upload disabled).

## Steps (safe defaults)
1. Only log non-sensitive analytics events.
2. Avoid putting secrets (tokens/passwords) into analytics or crash breadcrumbs.
3. Record errors using Crashlytics after network/repository failures are mapped (use `Result.Error` as the source of error info).
4. Keep analytics calls out of Composables for testability; call them from ViewModel/repository orchestration.

