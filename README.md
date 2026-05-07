## AndroidBase

AndroidBase is a Kotlin Android boilerplate that uses Jetpack Compose and a layered architecture, following common best practices (Hilt, Coroutines, Flow, Room, Retrofit, Moshi, Crashlytics).

### Tech stack

- **Language & UI**
  - **Kotlin**
  - **Jetpack Compose** (Material 3)
- **Dependency Injection**
  - **Hilt / Dagger Hilt**
- **Networking**
  - **Retrofit** + **Moshi**
  - `Result<T>` wrapper + `Response<BaseResponse<T>>.toResult()`
- **Persistence**
  - **Room** (`UserEntity`, `UserDao`, `AppDatabase`)
- **Async**
  - **Kotlin Coroutines** + **Flow / StateFlow**
- **Other**
  - **Firebase Crashlytics**

### Project structure

- `app/src/main/java/com/kira/android_base/app`
  - **`data`**
    - **`local`** – local data sources, Room DB, local storage
      - `db/AppDatabase.kt`, `db/dao/UserDao.kt`, `db/entity/UserEntity.kt`
      - `datasource/*LocalDataSource.kt`
      - `localstorage/LocalStorageManager.kt`
    - **`remote`** – Retrofit APIs + remote data sources
      - `apis/*Api.kt`, `APIModule.kt`, interceptors
      - `remote/datasource/*RemoteDataSource.kt`
      - Response model: `BaseResponse<T>`
    - **`repositories`** – domain‑facing layer combining local + remote
      - `AuthRepository`, `UserRepository`, `ContactRepository`
    - **`result`**
      - `Result<T>`: `Success<T>(data)`, `Error(code, message)`
      - `ResponseExtensions.kt`: `Response<BaseResponse<T>>.toResult()`, `Throwable.toError()`, `T.toResult()`
  - **`domain`**
    - **`model`** – domain/UI models (`User`, `Contact`, …)
    - Mapping between entities / responses and domain models (e.g. `toUser()`, `toUserEntity()` inside repositories)
  - **`presentation`**
    - **`common`**
      - `State<T>` – generic view state used across screens:
        - `isLoading: Boolean`
        - `data: T?`
        - `errorMessage: String?`
      - `fun <T> Result<T>.toState()`: converts `Result<T>` to `State<T>`
    - **`screens/home`**
      - `HomeScreen.kt`, `HomeViewModel.kt`
      - `components`:
        - `ContactsList`, `ContactItem`, `ContactSkeletonItem`
    - **`screens/login`**
      - `LoginScreen.kt`, `LoginViewModel.kt`
    - **`navigation`**
      - `AppNavigation.kt`
  - **`theme`**
    - `Color.kt`, `Theme.kt`, `Type.kt`

### Data & state flow

- **From API to UI**
  - **RemoteDataSource**  
    Calls Retrofit APIs (`AuthApi`, `UserApi`, `ContactApi`) and returns `Response<BaseResponse<T>>`.
  - **Repository**
    - Calls `remoteDataSource.*().toResult()` to get a `Result<T>`.
    - Handles side‑effects (save token, cache user to DB, etc.).
  - **`Result<T> -> State<T>`**
    - Uses `Result<T>.toState()` to convert to `State<T>`.
  - **ViewModel**
    - Holds `StateFlow<State<T>>`.
    - UI collects and renders according to `isLoading` / `data` / `errorMessage`.

- **Shared `State<T>` pattern**
  - **Loading**: `State(isLoading = true)`
  - **Success**: `State(data = T)`
  - **Error**: `State(errorMessage = String)`
  - Reused across screens (login, user info, lists, etc.).

### Current APIs

- **Auth**
  - **Remote**:  
    `AuthRemoteDataSource.login(LoginRequest): Response<BaseResponse<String>>`
  - **Repository**: `AuthRepository`
    - `suspend fun login(email: String, password: String): Result<String>`  
      Calls `remoteDataSource.login(LoginRequest(email, password)).toResult()`.  
      On success, saves the token into `AuthLocalDataSource`.
  - **ViewModel**: `LoginViewModel`
    - Field: `val loginState: StateFlow<State<String>>`
    - `login(email, password)`:
      - Set `State(isLoading = true)`
      - Call `authRepository.login(email, password).toState()`
  - **UI**: `LoginScreen`
    - Disables the login button while `loginState.isLoading`.
    - Shows `Loading()` overlay while `loginState.isLoading`.
    - If `loginState.errorMessage != null`: shows an error message in the center of the screen.
    - When `loginState.data` is not null or empty: calls `onLoginSuccess()`.

- **User**
  - **Remote**:  
    `UserRemoteDataSource.fetchUser(): Response<BaseResponse<User>>`
  - **Repository**: `UserRepository`
    - `suspend fun getUser(): Result<User>`
      - First reads `localDataSource.userFlow.firstOrNull()`.
      - If a local user exists: converts to domain `User` and wraps in `Result.Success`.
      - Otherwise: calls `fetchUser()`.
    - `private suspend fun fetchUser(): Result<User>`  
      Calls `remoteDataSource.fetchUser().toResult()` and, on success:
      - Converts `User` to `UserEntity`.
      - Saves it via `localDataSource.saveUser(...)`.
  - **ViewModel**: `HomeViewModel`
    - Field: `val userState: StateFlow<State<User>>`
    - `getUser()`:
      - Set `State(isLoading = true)`
      - Call `userRepository.getUser().toState()`.
  - **UI**: `UserInfoSection` inside `HomeScreen`
    - If `data != null`: displays user name and email.
    - If `errorMessage != null`: displays an error message in error color.
    - Otherwise: shows “Loading user information…”.

- **Contacts**
  - **Remote**:  
    `ContactRemoteDataSource.fetchContacts(): Response<BaseResponse<List<Contact>>>`
  - **Repository**: `ContactRepository`
    - `suspend fun fetchContacts(): Result<List<Contact>>`  
      Calls `remoteDataSource.fetchContacts().toResult()`.
  - **ViewModel**: `HomeViewModel`
    - Field: `val contactsState: StateFlow<State<List<Contact>>>`
    - `fetchContacts()`:
      - Set `State(isLoading = true)`
      - Call `contactRepository.fetchContacts().toState()`.
  - **UI**: `ContactsSection` + `ContactsList`
    - If `errorMessage != null`:
      - Shows the error message above the list with a Retry button (calls `fetchContacts()`).
    - Always renders `ContactsList` with:
      - `isLoading = contactsState.isLoading` (shows skeleton items).
      - `contacts = contactsState.data.orEmpty()`.

### Hilt & navigation

- **Hilt**
  - `@HiltAndroidApp` on `MainApplication`.
  - `@AndroidEntryPoint` on the Activity / Compose host.
  - `@HiltViewModel` for `HomeViewModel` and `LoginViewModel`.
  - Hilt modules provide Retrofit, Room, local storage, etc.
- **Navigation**
  - `AppNavigation.kt` defines the navigation graph between Login and Home.
  - `hiltViewModel()` is used in composables to obtain the correct ViewModel instance.

### Guidelines for adding new features

- **Data layer**
  - **API**: create `*Api.kt` in `data/remote/apis`.
  - **RemoteDataSource**: create `*RemoteDataSource.kt` to wrap the API.
  - **Repository**: create `*Repository.kt` to:
    - Call `remoteDataSource.*().toResult()`.
    - Handle caching / persistence logic if needed.

- **Domain layer**
  - Define domain models in `domain/model`.
  - Add mapping functions between responses / entities and domain models.

- **Presentation layer**
  - Create a new package under `presentation/screens/<feature_name>`.
  - **ViewModel**:
    - Use `State<T>` + `Result<T>.toState()` for state handling.
    - Expose `StateFlow<State<T>>` for the UI.
  - **UI (Compose)**:
    - Split into smaller composables under `components` when appropriate.
    - Render based on `isLoading`, `data`, and `errorMessage` following the existing Login/Home patterns.

### Notes for developers

- `State<T>` and `Result<T>.toState()` are the core building blocks for view state across screens.
- Reuse the same state pattern for new APIs to keep behavior consistent (loading, success, error).

