package com.leo.fblogin.fb_user_data

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.leo.fblogin.R
import com.leo.fblogin.model.FBUser
import org.json.JSONException

class FbUserDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fb_user_data)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        getFBUserInfo {
            fbUser ->
            Glide.with(this@FbUserDataActivity).load(String.format(getString(R.string.facebook_image_url), fbUser.userId)).into(findViewById(R.id.user_image) as ImageView)
            (findViewById(R.id.user_name) as TextView).text = fbUser.username
        }
    }

    private fun getFBUserInfo(callback: (fbUser: FBUser) -> Unit) {
        val fbUser = FBUser()
        val request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken()) { `object`, response ->
            try {
                fbUser.username = `object`.getString("name")
                fbUser.userId = `object`.getString("id")
                callback(fbUser)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        request.executeAsync()
    }
}
