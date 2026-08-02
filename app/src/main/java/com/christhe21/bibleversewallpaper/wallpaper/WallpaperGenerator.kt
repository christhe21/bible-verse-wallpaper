package com.christhe21.bibleversewallpaper.wallpaper

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Shader
import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.WindowManager
import com.christhe21.bibleversewallpaper.data.Verse
import kotlin.math.max
import kotlin.math.min

/**
 * Generates a high-quality bitmap suitable for wallpaper with the given Bible verse.
 * Uses a soft elegant gradient + carefully wrapped text.
 */
object WallpaperGenerator {

    fun generate(context: Context, verse: Verse): Bitmap {
        val (width, height) = getDesiredWallpaperSize(context)

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // Soft elegant gradient background (deep blue → indigo → soft purple)
        val gradient = LinearGradient(
            0f, 0f, width.toFloat(), height.toFloat(),
            intArrayOf(
                Color.parseColor("#0D1B2A"),
                Color.parseColor("#1B263B"),
                Color.parseColor("#415A77"),
                Color.parseColor("#1B263B")
            ),
            floatArrayOf(0f, 0.35f, 0.7f, 1f),
            Shader.TileMode.CLAMP
        )
        val bgPaint = Paint().apply { shader = gradient }
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), bgPaint)

        // Subtle vignette / darkening at edges for better text readability
        val vignettePaint = Paint().apply {
            shader = LinearGradient(
                0f, 0f, 0f, height.toFloat(),
                intArrayOf(Color.TRANSPARENT, Color.parseColor("#40000000"), Color.TRANSPARENT),
                floatArrayOf(0f, 0.5f, 1f),
                Shader.TileMode.CLAMP
            )
        }
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), vignettePaint)

        val paddingHorizontal = width * 0.12f
        val maxTextWidth = width - (paddingHorizontal * 2)

        // Verse text paint
        val versePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            textAlign = Paint.Align.CENTER
            typeface = Typeface.create(Typeface.SERIF, Typeface.NORMAL)
            // Dynamic text size based on screen
            textSize = (width * 0.045f).coerceIn(42f, 72f)
        }

        // Reference paint (smaller, lighter)
        val refPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor("#B0C4DE")
            textAlign = Paint.Align.CENTER
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textSize = versePaint.textSize * 0.55f
        }

        // Word-wrap the verse text
        val lines = wrapText(verse.text, versePaint, maxTextWidth)

        // Calculate total text block height
        val lineHeight = versePaint.fontSpacing * 1.25f
        val verseBlockHeight = lines.size * lineHeight
        val spacing = height * 0.04f
        val refHeight = refPaint.fontSpacing

        val totalHeight = verseBlockHeight + spacing + refHeight
        var currentY = (height - totalHeight) / 2f + versePaint.textSize * 0.8f

        // Draw each line of the verse
        for (line in lines) {
            // Soft shadow for readability
            versePaint.setShadowLayer(8f, 0f, 3f, Color.parseColor("#80000000"))
            canvas.drawText(line, width / 2f, currentY, versePaint)
            currentY += lineHeight
        }

        // Draw reference
        currentY += spacing
        refPaint.setShadowLayer(6f, 0f, 2f, Color.parseColor("#80000000"))
        canvas.drawText("— ${verse.reference}", width / 2f, currentY, refPaint)

        // Small decorative line under reference
        val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor("#80B0C4DE")
            strokeWidth = 2.5f
        }
        val lineWidth = width * 0.12f
        canvas.drawLine(
            width / 2f - lineWidth / 2,
            currentY + refHeight * 0.6f,
            width / 2f + lineWidth / 2,
            currentY + refHeight * 0.6f,
            linePaint
        )

        return bitmap
    }

    private fun wrapText(text: String, paint: Paint, maxWidth: Float): List<String> {
        val words = text.split(" ")
        val lines = mutableListOf<String>()
        var currentLine = StringBuilder()

        for (word in words) {
            val testLine = if (currentLine.isEmpty()) word else "$currentLine $word"
            val width = paint.measureText(testLine)
            if (width <= maxWidth) {
                currentLine = StringBuilder(testLine)
            } else {
                if (currentLine.isNotEmpty()) {
                    lines.add(currentLine.toString())
                }
                currentLine = StringBuilder(word)
            }
        }
        if (currentLine.isNotEmpty()) {
            lines.add(currentLine.toString())
        }
        return lines
    }

    private fun getDesiredWallpaperSize(context: Context): Pair<Int, Int> {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val metrics = DisplayMetrics()
        @Suppress("DEPRECATION")
        windowManager.defaultDisplay.getRealMetrics(metrics)

        // Prefer the full screen size; WallpaperManager will handle scaling
        var width = metrics.widthPixels
        var height = metrics.heightPixels

        // Some devices report very large values; clamp reasonably
        val maxDim = 2560
        if (width > maxDim || height > maxDim) {
            val scale = maxDim.toFloat() / max(width, height)
            width = (width * scale).toInt()
            height = (height * scale).toInt()
        }

        // Ensure minimum quality
        width = max(width, 1080)
        height = max(height, 1920)

        return width to height
    }
}
