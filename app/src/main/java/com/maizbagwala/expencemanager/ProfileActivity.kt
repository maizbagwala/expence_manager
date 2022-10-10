package com.maizbagwala.expencemanager

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.maizbagwala.expencemanager.utils.Const.PREF_A_EMAIL
import com.maizbagwala.expencemanager.utils.Const.PREF_A_NAME
import com.maizbagwala.expencemanager.utils.Const.PREF_A_PHOTO
import com.maizbagwala.expencemanager.utils.Const.PREF_LOGIN
import com.maizbagwala.expencemanager.utils.Const.PREF_NAME

class ProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val sharedPref: SharedPreferences by lazy {
        getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()

        findViewById<TextView>(R.id.emailid).text = sharedPref.getString(PREF_A_EMAIL, "")
        findViewById<TextView>(R.id.username).text = sharedPref.getString(PREF_A_NAME, "")

        Glide
            .with(this)
            .load(sharedPref.getString(PREF_A_PHOTO, "")).circleCrop()
            .into(findViewById(R.id.iv_profile))

        findViewById<Button>(R.id.SignOutBtn).setOnClickListener {
            sharedPref.edit().putBoolean(PREF_LOGIN, false).apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }
    }
}