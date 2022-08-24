package com.maizbagwala.expencemanager

import android.content.Intent
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth=FirebaseAuth.getInstance()
        val email=intent.getStringExtra("email")
        val dispname=intent.getStringExtra("name")
        findViewById<TextView>(R.id.emailid).setText(email)
        findViewById<TextView>(R.id.username).setText(dispname)
        findViewById<Button>(R.id.Signoutbtn).setOnClickListener{
        auth.signOut()
            val ptol=Intent(this,Login::class.java)
            startActivity(ptol)
        }
    }
}