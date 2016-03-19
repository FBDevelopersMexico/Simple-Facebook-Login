package com.leo.fblogin.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment

/**
 * Created by Leo on 17/03/16.
 */
fun Activity.createIntentFromTo(from: Activity, to: Class<*>, finishFromActivity: Boolean): Intent {
    val intent = Intent(from, to)
    if (finishFromActivity) {
        from.finish()
    }
    return intent
}

fun Activity.navigateTo(context: Context, intent: Intent) {
    context.startActivity(intent)
}

fun Fragment.createIntentFromTo(from: Activity, to: Class<*>, finishFromActivity: Boolean): Intent {
    val intent = Intent(from, to)
    if (finishFromActivity) {
        from.finish()
    }
    return intent
}

fun Fragment.navigateTo(context: Context, intent: Intent) {
    context.startActivity(intent)
}
