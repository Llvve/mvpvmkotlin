package com.lightmock.core.binder

import android.content.Context
import android.widget.Toast

fun Any.toast(context: Context?, duration: Int) {
    if (context == null) {
        return
    }
    Toast.makeText(context, this.toString(), duration).show()
}