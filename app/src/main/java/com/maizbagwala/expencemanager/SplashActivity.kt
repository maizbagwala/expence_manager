package com.maizbagwala.expencemanager

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val sharedPref: SharedPreferences by lazy {
        getSharedPreferences("Emspref", Context.MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val eID=sharedPref.getString("accID",null)
        val eN=sharedPref.getString("accName",null)
        val bar: ProgressBar=findViewById(R.id.pbar)
        bar.visibility= View.VISIBLE
        val spl=Handler(Looper.getMainLooper())
        spl.postDelayed({
            if (eID == null && eN == null) {
                val splash = Intent(this, Login::class.java)
                startActivity(splash)
                finish()
            } else{
                val loggedin=Intent(this,MainActivity::class.java)
                loggedin.putExtra("name",eN)
                loggedin.putExtra("email",eID)
                startActivity(loggedin)
        } },2000)
    }
}