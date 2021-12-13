package com.example.course_attestation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


import kotlin.random.Random

const val HELLO_KEY2 = "HELLO"

class SecondActivity2 : AppCompatActivity() {


    lateinit var tvSecondActivity: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)




        setContentView(R.layout.activity_second2)
        tvSecondActivity = findViewById(R.id.tv_second_activity)

        val helloValue: String? = intent.extras?.getString(HELLO_KEY2)
        tvSecondActivity.text = helloValue


        val background2 = findViewById<View>(R.id.bkImage2)
        background2.setBackgroundResource(R.drawable.good_day)


        val btHoliday = findViewById<Button>(R.id.btHoliday)
        val btSalary = findViewById<Button>(R.id.btSalary)
        btSalary.setOnClickListener {



            val temporaryText = "Вам начислено ${Constance.salary2} руб."
            val tvResult2 = findViewById<TextView>(R.id.tvResult2)
            tvResult2.visibility = (View.VISIBLE)
            tvResult2.setBackgroundColor(Color.GREEN)
            tvResult2.text =temporaryText
            btSalary.visibility = (View.INVISIBLE)
            btHoliday.visibility = (View.VISIBLE)

        }


        btHoliday.setOnClickListener {


            var tvResult2 = findViewById<TextView>(R.id.tvResult2)
            tvResult2.visibility = (View.VISIBLE)
            tvResult2.setBackgroundColor(Color.GREEN)
            btSalary.visibility = (View.VISIBLE)
            btHoliday.visibility = (View.INVISIBLE)

            val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                              16,17,18,19,20,21,22,23,24,25,26,27,28)
            val random = Random
            val temporaryNumber = random.nextInt(list.size)
            when(temporaryNumber){

                2,3,4,22,23,24 -> tvResult2.text = "В этом году осталось $temporaryNumber дня"
                1,21 -> tvResult2.text = "В этом году остался $temporaryNumber день"
                5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 -> tvResult2.text = "В этом году осталось $temporaryNumber дней"
            }










        }







    }
}