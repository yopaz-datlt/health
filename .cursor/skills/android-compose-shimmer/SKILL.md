---
name: android-compose-shimmer
description: Implement skeleton/shimmer loading UI in AndroidBase using compose-shimmer. Use when adding placeholder list rows/items while data loads.
---

# Android Compose Shimmer Workflow
## Conventions
- Skeleton items use `Modifier.shimmer()` from `com.valentinilk.shimmer.shimmer`.
- Skeleton components live under the same feature `components/` folder as real items.

## Steps
1. Create a skeleton Composable (e.g. `*SkeletonItem`).
2. Apply `modifier.shimmer()` to the placeholder layout.
3. In the list UI, switch between skeleton and real items based on `isLoading`.

