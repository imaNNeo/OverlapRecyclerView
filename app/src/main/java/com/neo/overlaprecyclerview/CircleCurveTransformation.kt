package com.neo.overlaprecyclerview

import android.graphics.*
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */

class CircleCurveTransformation(
        var curveRadius : Int
) : BitmapTransformation() {
    override fun updateDiskCacheKey(messageDigest: MessageDigest) {}

    override fun transform(pool: BitmapPool, toTransform: Bitmap,
                           width: Int, height: Int): Bitmap {

        curveRadius = -Math.abs(curveRadius)

        var result = pool.get(width, height, Bitmap.Config.ARGB_8888)
        // If no matching Bitmap is in the pool, get will return null, so we should allocate.
        if (result == null) {
            // Use ARGB_8888 since we're going to add alpha to the image.
            result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        }

        val canvas = Canvas(result)
        val clearPaint = Paint(Paint.ANTI_ALIAS_FLAG)

        val radius = (width / 2).toFloat()
        val widthF = width.toFloat()
        val heightF = height.toFloat()

        //Make Image Circle
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, clearPaint)


        clearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(toTransform, 0f, 0f, clearPaint)

        clearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas.drawCircle(widthF + (widthF / 2) + curveRadius, heightF / 2, radius, clearPaint)

        return result
    }

    override fun hashCode() = "asdf".hashCode()
    override fun equals(other: Any?) = true

}