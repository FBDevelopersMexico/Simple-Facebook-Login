package com.leo.fblogin.utils

import android.app.Activity
import android.support.v4.app.Fragment
import com.facebook.AccessToken

/**
 * Created by Leo on 17/03/16.
 */
fun Activity.isLoggedIn(): Boolean {
    return AccessToken.getCurrentAccessToken() != null
}

fun Fragment.isLoggedIn(): Boolean {
    return AccessToken.getCurrentAccessToken() != null
}
