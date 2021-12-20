package com.example.course_attestation

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import kotlin.random.Random

const val HELLO_KEY1 = "HELLO"

class SecondActivity1 : AppCompatActivity() {

    lateinit var tvSecondActivity: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second1)

        tvSecondActivity = findViewById(R.id.tv_second_activity)
        val helloValue: String? = intent.extras?.getString(HELLO_KEY1)
        tvSecondActivity.text = helloValue
        val background1 = findViewById<View>(R.id.bkImage1)
        background1.setBackgroundResource(R.drawable.good_day1)
        val btHoliday = findViewById<Button>(R.id.btHoliday)
        val btSalary = findViewById<Button>(R.id.btSalary)

        btSalary.setOnClickListener {
            val temporaryText = getString(R.string.you_earned)+" ${Constance.salary1}"
            val tvResult1 = findViewById<TextView>(R.id.tvResult1)
            tvResult1.visibility = (View.VISIBLE)
            tvResult1.setBackgroundColor(Color.GREEN)
            tvResult1.text =temporaryText
            btSalary.visibility = (View.INVISIBLE)
            btHoliday.visibility = (View.VISIBLE)
        }

        btHoliday.setOnClickListener {
            val tvResult1 = findViewById<TextView>(R.id.tvResult1)
            tvResult1.visibility = (View.VISIBLE)
            tvResult1.setBackgroundColor(Color.GREEN)
            btSalary.visibility = (View.VISIBLE)
            btHoliday.visibility = (View.INVISIBLE)
            val list = listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                              16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
            val random = Random
            val temporaryNumber = random.nextInt(list.size)
            tvResult1.text = getString(R.string.this_year_you_have)+" $temporaryNumber"

            /*when(temporaryNumber){
                2,3,4,22,23,24 -> tvResult1.text = "В этом году осталось $temporaryNumber дня"
                1,21 -> tvResult1.text = "В этом году остался $temporaryNumber день"
                //5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 -> tvResult1.text = "В этом году осталось $temporaryNumber дней"
                else -> tvResult1.text = "В этом году осталось $temporaryNumber дней"
            }*/
        }

    }

}