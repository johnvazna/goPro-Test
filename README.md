# GoPro Android Streaming Feature

This project demonstrates a **GoPro video streaming feature** for Android, built with **Jetpack Compose**, **ExoPlayer (Media3)**, **Retrofit**, and **Hilt**. It follows **SOLID** principles, **Clean Architecture**, and uses **Kotlin Coroutines & Flow** for data handling.

---

## 📌 Key Features

* **Video List**: Fetches a remote JSON using Retrofit + Gson and maps it to domain models.
* **Jetpack Compose UI**: Single screen

  1. **Fetch Stream button** (to load or refresh videos).
  2. **Loading spinner** or **error message** while fetching.
  3. **LazyColumn of videos** showing title, author, and a Play button.
  4. **Bottom bar** containing the Fetch Stream button.
* **Playback**: Navigates to `PlaybackScreen`, which hosts an ExoPlayer `PlayerView` with built-in controls.
* **State Management**: `StreamViewModel` leverages a generic `FlowUseCase` to load data and exposes a `StateFlow<Result<List<Video>>>`.
* **Dependency Injection**: Hilt modules for Retrofit, repository, streaming strategy, and ViewModels.
* **Unit Testing**: Tests for the ViewModel and `StreamState` extensions (`isLoading`, `isStreaming`).

---

## 🗂 Project Structure

```plaintext
app/                # Application module (MainActivity, NavHost)
stream_feature/     # Streaming feature module
  ├─ data/          # Data layer (Retrofit API, DTOs, Repository)
  ├─ domain/        # Domain layer (models, FlowUseCase)
  ├─ presentation/  # UI with Compose, ViewModel, state utilities
  ├─ di/            # Hilt dependency injection module
  └─ strategy/      # StreamStrategy implementation with ExoPlayer

core/               # Core module (sealed Result, base UseCase)

build.gradle        # Top-level Gradle configuration
settings.gradle     # Includes app, stream_feature, core modules
```

---

## ⚙️ Requirements

* Android Studio Flamingo or later
* Android SDK API 33+
* Kotlin 1.8+
* Gradle 7.5+

---

## 🚀 Installation & Usage

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/GoProStreamingAndroid.git
   cd GoProStreamingAndroid
   ```
2. **Open in Android Studio** and sync Gradle.
3. **Enable Hilt plugin** in `app/build.gradle`:

   ```groovy
   plugins {
        id("android-application-convention")
        id("hilt-convention")
   }
   ```
4. **Run** the app on an emulator or physical device.

---

## 📝 Implementation Details

* **Networking**: Retrofit + Gson

  * **`VideoApi`**: Single endpoint `takehome-android.json` returns `VideosResponse`.
  * **`NetworkModule`**: Provides a configured `Retrofit` instance with `GsonConverterFactory`.

* **Domain Layer**:

  * **`Video`** data class (title, author, URL).
  * **`GetVideosUseCase`** extends `FlowUseCase<Unit, List<Video>>`.

* **Presentation Layer**:

  * **`StreamViewModel`** exposes `StateFlow<Result<List<Video>>>` and a `refresh()` method.
  * **`ProfessionalVideoScreen`**: Compose screen with Scaffold, video list, state handling, and navigation.
  * **`PlaybackScreen`**: Compose screen embedding an ExoPlayer `PlayerView` via `AndroidView`.

* **State Handling**:

  * Sealed `Result<Loading, Success, Error>` for API responses.
  * Extensions `StreamState.isLoading` and `StreamState.isStreaming` (with unit tests).

* **Dependency Injection (Hilt)**:

  * **`FeatureStreamModule`**: Binds repository and streaming strategy, provides API.
  * Annotate application class with `@HiltAndroidApp` and `MainActivity` with `@AndroidEntryPoint`.

---
