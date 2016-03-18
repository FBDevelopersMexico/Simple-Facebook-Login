package com.leo.fblogin.app;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by Leo on 17/03/16.
 */
public class FBLoginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(this);
    }
}
