package com.maizbagwala.expencemanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth=FirebaseAuth.getInstance()
        val email=intent.getStringExtra("email")
        val dispname=intent.getStringExtra("name")
        findViewById<TextView>(R.id.emailid).text = email
        findViewById<TextView>(R.id.username).text = dispname
        findViewById<Button>(R.id.Signoutbtn).setOnClickListener{
        auth.signOut()
            val ptol=Intent(this,Login::class.java)
            startActivity(ptol)
        }
    }
}