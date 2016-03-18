package com.leo.fblogin.utils;

import com.facebook.AccessToken;

/**
 * Created by Leo on 17/03/16.
 */
public class FbSessionUtils {

    public static boolean isLoggedIn() {
        return AccessToken.getCurrentAccessToken() != null;
    }
}
