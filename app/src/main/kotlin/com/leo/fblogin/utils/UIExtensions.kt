package com.leo.fblogin.utils

import android.app.Activity
import android.support.design.widget.Snackbar

/**
 * Created by Leo on 18/03/16.
 */

fun Activity.createSnackbar(message:String = "", duration:Int = 0){
    var snackbar = Snackbar.make(this.findViewById(android.R.id.content),message,duration)
    snackbar.show()
}

