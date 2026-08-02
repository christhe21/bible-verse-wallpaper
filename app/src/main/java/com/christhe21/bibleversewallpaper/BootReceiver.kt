package com.christhe21.bibleversewallpaper

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.christhe21.bibleversewallpaper.data.PreferencesManager
import com.christhe21.bibleversewallpaper.wallpaper.WallpaperWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * Reschedules the daily wallpaper work after device reboot
 * if the user had auto-wallpaper enabled.
 */
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            val pendingResult = goAsync()
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val prefs = PreferencesManager(context)
                    val enabled = prefs.autoWallpaperEnabled.first()
                    if (enabled) {
                        WallpaperWorker.schedule(context)
                    }
                } finally {
                    pendingResult.finish()
                }
            }
        }
    }
}
