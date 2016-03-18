package com.leo.fblogin.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Leo on 17/03/16.
 */
public class UIUtils {

    public static Snackbar createSnackbar(View container, String message, int duration) {
        return Snackbar.make(container, message, duration);
    }
}
