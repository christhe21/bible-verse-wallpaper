package com.christhe21.bibleversewallpaper.wallpaper

import android.app.WallpaperManager
import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.christhe21.bibleversewallpaper.data.VerseRepository
import com.christhe21.bibleversewallpaper.widget.VerseWidgetProvider
import java.util.concurrent.TimeUnit

class WallpaperWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            val verse = VerseRepository.getTodaysVerse()
            val bitmap = WallpaperGenerator.generate(applicationContext, verse)

            val wallpaperManager = WallpaperManager.getInstance(applicationContext)

            // Set both home and lock screen when possible
            try {
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
            } catch (e: Exception) {
                // Fallback for older APIs or restricted devices
                wallpaperManager.setBitmap(bitmap)
            }

            // Also refresh the home screen widget
            VerseWidgetProvider.updateAllWidgets(applicationContext)

            Log.d(TAG, "Wallpaper set successfully for: ${verse.reference}")
            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to set wallpaper", e)
            Result.retry()
        }
    }

    companion object {
        private const val TAG = "WallpaperWorker"
        const val WORK_NAME = "daily_bible_wallpaper"

        /**
         * Schedule the daily wallpaper job.
         * Runs approximately once every 24 hours.
         */
        fun schedule(context: Context) {
            val request = PeriodicWorkRequestBuilder<WallpaperWorker>(
                24, TimeUnit.HOURS,
                2, TimeUnit.HOURS // flex interval
            ).build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.UPDATE,
                request
            )
        }

        fun cancel(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
        }

        /** Run once immediately (for "Set Now" button) */
        fun runNow(context: Context) {
            val request = androidx.work.OneTimeWorkRequestBuilder<WallpaperWorker>().build()
            WorkManager.getInstance(context).enqueue(request)
        }
    }
}
