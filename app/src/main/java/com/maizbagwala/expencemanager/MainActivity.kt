package com.maizbagwala.expencemanager

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.maizbagwala.expencemanager.utils.Const.PREF_A_NAME
import com.maizbagwala.expencemanager.utils.Const.PREF_A_PHOTO
import com.maizbagwala.expencemanager.utils.Const.PREF_NAME

class MainActivity : AppCompatActivity() {
    lateinit var ivProfile: ImageView
    lateinit var tvName: TextView
    lateinit var sp: SharedPreferences
    lateinit var addBtn: TextView

    var name: String = ""
    var photo: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivProfile = findViewById(R.id.iv_profile)
        tvName = findViewById(R.id.Name)
        addBtn = findViewById(R.id.add_btn)

        sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        name = sp.getString(PREF_A_NAME, "").toString()
        photo = sp.getString(PREF_A_PHOTO, "").toString()



        tvName.text = name
        Glide.with(this).load(photo).circleCrop().into(ivProfile)

        ivProfile.setOnClickListener {
            val mtop = Intent(this, ProfileActivity::class.java)
            mtop.putExtra("name", name)
            mtop.putExtra("image", photo)
            startActivity(mtop)
        }
        addBtn.setOnClickListener {
            startActivity(Intent(this, AddAmountActivity::class.java))
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
        }
    }

//    override fun finish() {
//        super.finish()
//        overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up)
//    }
}