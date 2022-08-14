package com.maizbagwala.expencemanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val bar: ProgressBar=findViewById(R.id.pbar)
        bar.visibility= View.VISIBLE
        val spl=Handler(Looper.getMainLooper())
        spl.postDelayed({
            val splash= Intent(this,Login::class.java)
            startActivity(splash)
            finish()
        },2000)
    }
}