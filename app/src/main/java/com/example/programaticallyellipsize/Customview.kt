package com.example.programaticallyellipsize

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View


class MyCustomView(context: Context?) : View(context) {
    private val mRectangle: Rect
    private val rectPaint: Paint = Paint()
    private val textPaint: Paint = Paint()
    private val yourText = "Hello, world!"
    private val padding = 20

    init {
        rectPaint.color = Color.BLACK

        textPaint.color = Color.WHITE
        textPaint.textSize = 48f

        val sideLength = 200

        val left = 50

        val textWidth: Float = textPaint.measureText(yourText)
        val totalWidth = (textWidth + 2 * padding).toInt()

        val screenHeight = resources.displayMetrics.heightPixels
        val centerY = screenHeight / 2

        val top = centerY - (sideLength / 2)
        val bottom = centerY + (sideLength / 2)
        mRectangle = Rect(left, top, left + totalWidth, bottom)

    }

    override fun onDraw(canvas: Canvas) {
        val textHeight = textPaint.descent() - textPaint.ascent()

        val textY = mRectangle.centerY() + textHeight / 2f

        canvas.drawRect(mRectangle, rectPaint)

        val textX = mRectangle.left.toFloat() + padding
        canvas.drawText(yourText, textX, textY, textPaint)
    }
}

