package com.leo.fblogin.fb_user_data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.leo.fblogin.R;
import com.leo.fblogin.model.FBUser;

import org.json.JSONException;
import org.json.JSONObject;

public class FbUserDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_user_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getFBUserInfo(new UserDataCallback() {
            @Override
            public void userData(FBUser user) {

                Glide.with(FbUserDataActivity.this)
                        .load(String.format(getString(R.string.facebook_image_url), user.userId))
                        .into((ImageView) findViewById(R.id.user_image));

                ((TextView) findViewById(R.id.user_name)).setText(user.username);
            }
        });
    }

    private void getFBUserInfo(final UserDataCallback userDataCallback) {
        final FBUser fbUser = new FBUser();
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    fbUser.username = object.getString("name");
                    fbUser.userId = object.getString("id");
                    userDataCallback.userData(fbUser);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        request.executeAsync();
    }

    interface UserDataCallback {
        void userData(FBUser user);
    }
}
