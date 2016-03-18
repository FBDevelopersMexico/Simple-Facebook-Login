package com.leo.fblogin.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.leo.fblogin.R;
import com.leo.fblogin.fb_user_data.FbUserDataActivity;
import com.leo.fblogin.utils.FbSessionUtils;
import com.leo.fblogin.utils.NavigatorUtils;
import com.leo.fblogin.utils.UIUtils;

public class FBLoginActivity extends AppCompatActivity implements FacebookCallback<LoginResult> {

    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fblogin);

        mCallbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.fb_login_button);
        loginButton.registerCallback(mCallbackManager, this);

        if (FbSessionUtils.isLoggedIn()) {
            NavigatorUtils.navigateTo(this, NavigatorUtils.createIntentFromTo(this, FbUserDataActivity.class, true /* finish from activity*/));
        }
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        NavigatorUtils.navigateTo(this, NavigatorUtils.createIntentFromTo(this, FbUserDataActivity.class, true /* finish from activity*/));
    }

    @Override
    public void onCancel() {
        UIUtils.createSnackbar(findViewById(android.R.id.content), getString(R.string.fb_cancel_login), Snackbar.LENGTH_SHORT);
    }

    @Override
    public void onError(FacebookException error) {
        if (error != null) {
            UIUtils.createSnackbar(findViewById(android.R.id.content), getString(R.string.fb_error_login), Snackbar.LENGTH_SHORT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
