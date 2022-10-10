package com.maizbagwala.expencemanager

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.icu.util.Calendar.getInstance
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class AddAmountActivity : AppCompatActivity() {
    private var lastdate :EditText=findViewById(R.id.lastdate)
    private val calendar: Calendar = getInstance()
    private val day=calendar.get(Calendar.DAY_OF_MONTH)
    private val month=calendar.get(Calendar.MONTH)
    private val year=calendar.get(Calendar.YEAR)
    val reminder: Array<String> = resources.getStringArray(R.array.reminder)
    private val spinner: Spinner =findViewById(R.id.reminder)
    private val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,reminder)
    private var remindbar:Slider=findViewById(R.id.remindbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_amount)

        //for Spinner
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (reminder[position]==reminder[3]){
                    Toast.makeText(this@AddAmountActivity,"nice",Toast.LENGTH_LONG).show()
                    }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("don't do anything")
                }
            }

        //for last date selector popup

        lastdate.setOnClickListener {
            val dmy=DatePickerDialog(this, { _, myear, mmonth, mday ->
                lastdate.setText("  $mday/$mmonth/$myear")
            },year,month,day)
            dmy.show()
        }

       //SeekBar

    }
//        override fun onBackPressed() {
//            super.onBackPressed()
//            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
//        }
    }

