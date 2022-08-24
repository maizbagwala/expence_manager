package com.maizbagwala.expencemanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Name=intent.getStringExtra("name")
        val Email=intent.getStringExtra("email")
        findViewById<TextView>(R.id.Name).setText(Name)
        findViewById<Button>(R.id.Prfl).setOnClickListener {
            val mtop= Intent(this,ProfileActivity::class.java)
            mtop.putExtra("name",Name)
            mtop.putExtra("email",Email)
            startActivity(mtop)
        }
    }
}