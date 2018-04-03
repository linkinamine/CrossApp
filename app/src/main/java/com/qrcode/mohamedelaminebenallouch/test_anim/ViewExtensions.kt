package com.qrcode.mohamedelaminebenallouch.test_anim

import android.content.res.Resources

val Int.toPx: Float
    get() = (this * Resources.getSystem().displayMetrics.density)

val Int.toDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()