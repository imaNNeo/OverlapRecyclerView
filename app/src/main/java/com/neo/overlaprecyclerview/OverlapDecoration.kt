package com.neo.overlaprecyclerview

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.load.data.LocalUriFetcher

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
class OverlapDecoration(
        val leftPadding: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        super.getItemOffsets(outRect, itemPosition, parent)
        if (itemPosition != 0) {
            outRect.left = -Math.abs(leftPadding)
        }
    }
}
