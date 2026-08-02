# Bible Verse Wallpaper

An Android app that automatically refreshes your home & lock screen wallpaper every day with a beautiful Bible verse.

Also includes a home screen **widget** that displays the verse of the day.

## Features

- **Daily Auto Wallpaper**: Generates an elegant image with a soft gradient background + Bible verse and sets it as wallpaper every day.
- **Home Screen Widget**: Shows today's verse. Updates automatically.
- **Manual Set**: Open the app and set today's wallpaper instantly.
- **Offline**: All verses are embedded — no internet required.
- **Modern UI**: Built with Jetpack Compose + Material 3.
- **Reliable scheduling**: Uses WorkManager (survives reboot).

## Screenshots

*(Coming soon — open a PR with screenshots!)*

## How it works

1. On first launch, grant wallpaper permission if needed.
2. Enable "Auto Wallpaper" toggle.
3. A daily `WorkManager` job runs (around midnight or when conditions are met).
4. It picks a verse based on the day of the year, generates a high-quality bitmap, and applies it via `WallpaperManager`.
5. The widget also updates with the same verse.

## Tech Stack

- Kotlin
- Jetpack Compose + Material 3
- WorkManager
- App Widgets (classic RemoteViews)
- DataStore / SharedPreferences for settings

## Getting Started

1. Clone the repo
2. Open in **Android Studio** (Hedgehog or newer recommended)
3. Sync Gradle
4. Run on a device/emulator (API 26+)

```bash
git clone https://github.com/christhe21/bible-verse-wallpaper.git
```

## Project Structure

```
app/
├── src/main/java/com/christhe21/bibleversewallpaper/
│   ├── MainActivity.kt
│   ├── data/
│   │   ├── Verse.kt
│   │   └── VerseRepository.kt
│   ├── wallpaper/
│   │   ├── WallpaperGenerator.kt
│   │   └── WallpaperWorker.kt
│   ├── widget/
│   │   └── VerseWidgetProvider.kt
│   └── ui/
│       └── theme/
└── src/main/res/
    ├── layout/verse_widget.xml
    ├── xml/verse_widget_info.xml
    └── values/
```

## Customization Ideas

- Add more verses (edit `VerseRepository`)
- Change wallpaper style (colors, fonts, layout) in `WallpaperGenerator`
- Support multiple languages / Bible translations
- Dark / Light wallpaper themes
- Favorite verses

## License

MIT — feel free to fork and improve.

---

Made with ❤️ for daily encouragement.
