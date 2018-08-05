package com.neo.overlaprecyclerview

import android.content.res.Resources

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
fun Int.toDp() = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx() = (this * Resources.getSystem().displayMetrics.density).toInt()