package com.christhe21.bibleversewallpaper.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferencesManager(private val context: Context) {

    private val AUTO_WALLPAPER_KEY = booleanPreferencesKey("auto_wallpaper_enabled")

    val autoWallpaperEnabled: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[AUTO_WALLPAPER_KEY] ?: false
    }

    suspend fun setAutoWallpaperEnabled(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[AUTO_WALLPAPER_KEY] = enabled
        }
    }
}
