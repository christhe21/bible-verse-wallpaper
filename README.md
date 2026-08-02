# Bible Verse Wallpaper

An Android app that **automatically refreshes your home & lock screen wallpaper every day** with a beautiful Bible verse.

Also includes a **home screen widget** that displays the verse of the day.

🔗 **Repository**: https://github.com/christhe21/bible-verse-wallpaper

## Features

- **Daily Auto Wallpaper**  
  Generates an elegant image (soft gradient + carefully wrapped verse text) and sets it as wallpaper every day using WorkManager.

- **Home Screen Widget**  
  Shows today's verse. Tap to open the app. Updates automatically when the wallpaper changes.

- **Manual "Set Now"**  
  Instantly apply today's wallpaper from the app.

- **Fully Offline**  
  90+ curated Bible verses (KJV style) are embedded. No internet required.

- **Modern UI**  
  Jetpack Compose + Material 3. Clean dark/light adaptive theme.

- **Survives Reboot**  
  BootReceiver re-schedules the daily job if auto-wallpaper is enabled.

## Screenshots

*(Add screenshots after first run — the generated wallpaper looks like a calm navy/indigo gradient with white serif verse text centered.)*

## How it works

1. Open the app → enable **Auto Wallpaper** toggle.  
2. WorkManager schedules a periodic job (~every 24 hours).  
3. Each day a verse is selected based on `dayOfYear % verses.size`.  
4. `WallpaperGenerator` creates a high-resolution bitmap and applies it via `WallpaperManager` (home + lock screen).  
5. The widget is also refreshed with the same verse.

## Tech Stack

| Component          | Technology                  |
|--------------------|-----------------------------|
| Language           | Kotlin                      |
| UI                 | Jetpack Compose + Material 3|
| Background work    | WorkManager                 |
| Preferences        | DataStore                   |
| Widget             | AppWidgetProvider + RemoteViews |
| Min SDK            | 26 (Android 8.0)            |
| Target SDK         | 35                          |

## Getting Started

### 1. Clone

```bash
git clone https://github.com/christhe21/bible-verse-wallpaper.git
cd bible-verse-wallpaper
```

### 2. Open in Android Studio

- Android Studio **Ladybug** / **Hedgehog** or newer recommended.
- Let Gradle sync (first time may download dependencies).

### 3. Generate proper launcher icons (optional but recommended)

Right-click `res` → **New → Image Asset** → choose an icon and generate all densities.  
The project currently ships with a simple adaptive vector icon.

### 4. Run

Select a device / emulator (API 26+) and press **Run**.

### 5. Add the Widget

Long-press on home screen → Widgets → find **Daily Bible Verse** → place it.

## Project Structure

```
app/src/main/java/com/christhe21/bibleversewallpaper/
├── MainActivity.kt                 # Compose UI
├── BootReceiver.kt                 # Re-schedule after reboot
├── data/
│   ├── Verse.kt
│   ├── VerseRepository.kt         # 90+ verses + day-of-year selection
│   └── PreferencesManager.kt      # DataStore for auto-toggle
├── wallpaper/
│   ├── WallpaperGenerator.kt      # Canvas drawing of verse image
│   └── WallpaperWorker.kt         # WorkManager worker
├── widget/
│   └── VerseWidgetProvider.kt
└── ui/theme/
    ├── Theme.kt
    └── Type.kt
```

## Customization Ideas

- Add more verses in `VerseRepository.kt`
- Change gradient colors / fonts / layout in `WallpaperGenerator.kt`
- Support different Bible translations
- Add "favorite this verse"
- Light / dark wallpaper themes
- Custom schedule time (instead of ~24h periodic)

## Permissions

- `SET_WALLPAPER` — required to change wallpaper
- `RECEIVE_BOOT_COMPLETED` — to restore the daily schedule after reboot
- `WAKE_LOCK` — used by WorkManager

## License

MIT — feel free to fork, improve, and share.

---

Made for daily encouragement ✨
