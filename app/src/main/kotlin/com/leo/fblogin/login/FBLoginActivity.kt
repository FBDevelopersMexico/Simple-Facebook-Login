package com.leo.fblogin.login

import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.leo.fblogin.R
import com.leo.fblogin.fb_user_data.FbUserDataActivity
import com.leo.fblogin.utils.*

class FBLoginActivity : AppCompatActivity(), FacebookCallback<LoginResult> {

    private var mCallbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fblogin)

        mCallbackManager = CallbackManager.Factory.create()
        val loginButton = findViewById(R.id.fb_login_button) as LoginButton
        loginButton.registerCallback(mCallbackManager, this)

        if (isLoggedIn()) {
            navigateTo(this, createIntentFromTo(this, FbUserDataActivity::class.java, true /* finish from activity*/))
        }
    }

    override fun onSuccess(loginResult: LoginResult) {
        navigateTo(this, createIntentFromTo(this, FbUserDataActivity::class.java, true /* finish from activity*/))
    }

    override fun onCancel() {
        createSnackbar(getString(R.string.fb_cancel_login), Snackbar.LENGTH_SHORT)
    }

    override fun onError(error: FacebookException?) {
        if (error != null) {
            createSnackbar(getString(R.string.fb_error_login), Snackbar.LENGTH_SHORT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        mCallbackManager!!.onActivityResult(requestCode, resultCode, data)
    }

}
