package com.leo.fblogin.app

import android.app.Application

import com.facebook.FacebookSdk

/**
 * Created by Leo on 17/03/16.
 */
class FBLoginApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(this)
    }
}
