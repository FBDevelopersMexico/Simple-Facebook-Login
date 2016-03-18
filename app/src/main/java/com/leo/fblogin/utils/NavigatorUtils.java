package com.leo.fblogin.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Leo on 17/03/16.
 */
public class NavigatorUtils {

    public static Intent createIntentFromTo(Activity from, Class<?> to, boolean finishFromActivity) {
        Intent intent = new Intent(from, to);
        if (finishFromActivity) {
            from.finish();
        }
        return intent;
    }

    public static void navigateTo(Context context, Intent intent) {
        context.startActivity(intent);
    }
}
