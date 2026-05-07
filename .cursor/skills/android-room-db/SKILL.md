---
name: android-room-db
description: Implement local persistence using Room in AndroidBase. Use when adding new entities/DAOs, updating queries, or wiring DAOs into the database module.
---

# Android Room DB Workflow
## Conventions
- Entities live in `app/data/local/db/entity/`.
- DAOs live in `app/data/local/db/dao/`.
- Database is `app/data/local/db/AppDatabase.kt`.
- Hilt wiring is `app/data/local/db/DatabaseModule.kt`.

## Steps
1. Add a new `@Entity` data class under `entity/` and update `AppDatabase` `entities = [...]`.
2. Add a `@Dao` interface with:
   - `Flow<T>` for query observation
   - `suspend` for insert/delete/update operations
3. Update `DatabaseModule` to provide the new DAO from `AppDatabase`.
4. Create/extend a local datasource under `app/data/local/datasource/*LocalDataSource.kt` to expose DAO operations to repositories.

## Notes
- Keep mapping helpers close to entities (example: `UserEntity.toUser()`).

