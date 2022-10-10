package com.maizbagwala.expencemanager

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.maizbagwala.expencemanager.utils.Const.PREF_LOGIN
import com.maizbagwala.expencemanager.utils.Const.PREF_NAME

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({
            if (sharedPref.getBoolean(PREF_LOGIN, false)) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2000)
    }
}