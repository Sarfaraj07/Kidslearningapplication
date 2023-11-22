package com.example.bebanggis

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*

class Quiz : AppCompatActivity() {

    lateinit var dialog : Dialog
    lateinit var buttonYes : Button
    lateinit var buttonNo : Button
    lateinit var buttonX : ImageButton

    var questions = arrayOf(
        "1.What do you call the person who brings a letter to your home from post office?",
        "2.Which day comes after Friday?",
        "3.How many letters are there in the English alphabet?",
        "4.Which is the smallest planet in the solar system?",
        "5.Which star is nearest to the Earth?",
        "6.Which planet is also called the Red Planet?",
        "7.Who was the first person to land on the moon?",
        "8.Who is the current Prime Minister of India?",
        "9.Who was the first prime minister of india?",
        "10.Which is the tallest mountain in the world?",
        "11.What is the capital of India?",
        "12.Which is the longest river in the world?",
        "13.How many months do we have in a year?",
        "14.How many days do we have in a weeks?",
        "15.How many days are there in a year?"
    )
    var answers = arrayOf(
        "Postman",
        "Saturday",
        "26",
        "Mercury",
        "Sun",
        "Mars",
        "Neil Armstrong",
        "Narendra Modi",
        "Jawaharlal Nehru",
        "Mount Everest",
        "Delhi",
        "The Nile",
        "12",
        "7",
        "365"
    )
    var opt = arrayOf(
        "Traffic Police", "Postman", "Police Man", "Watch Man",
        "Monday", "Tuesday", "wednesday", "Saturday",
        "20", "15", "26", "35",
        "Milky Way", "Mercury", "Sun", "Saturn",
        "Sun", "Moon", "Jupiter", "Star",
        "Neptun", "Mercury", "Sun", "Mars",
        "David Scott","Pete Conrad", "Buzz Aldrin", " Neil Armstrong",
        "Narendra Modi", "Gulzarilal Nanda", "Indira Gandhi", "Manmohan Singh",
        "Rajiv Gandhi", "Jawaharlal Nehru", "Vishwanath Pratap Singh", "Chandra Shekhar" ,
        "Mount Everest", "Kangchenjunga", "Lhotse", "Broad Peak",
        "Delhi", "Maharastra", "Assam", "Lucknow",
        "Lena", " The Nile", "Niger", "Tocantins–Araguaia",
        "10", "5", "12", "6",
        "10", "4", "13", "7",
        "200", "250", "365", "300"
    )

    var flag = 0
    var marks : Int = 0
    var correct : Int = 0
    var ans : String = ""
    var no = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        dialog = Dialog(this)

        val level = intent.getStringExtra("Level").toString()
        if (level == "1"){
            nomorlevel.text = "/5"
        }
        else if (level == "2"){
            nomorlevel.text = "/10"
        }
        else {
            nomorlevel.text = "/15"
        }
        textView7.text = no.toString()

        soal.text = questions[flag]
        option_a.text = opt[0]
        option_b.text = opt[1]
        option_c.text = opt[2]
        option_d.text = opt[3]

        buttonjawab_a.setOnClickListener {
            ans = option_a.text.toString()
            buttona.setBackgroundResource(R.drawable.circlegreen)
            buttona.setTextColor(resources.getColor(R.color.colorPrimaryDark))
//
            buttonb.setBackgroundResource(R.drawable.circlepurple)
            buttonb.setTextColor(resources.getColor(R.color.white))

            buttonc.setBackgroundResource(R.drawable.circlepurple)
            buttonc.setTextColor(resources.getColor(R.color.white))

            buttond.setBackgroundResource(R.drawable.circlepurple)
            buttond.setTextColor(resources.getColor(R.color.white))
        }
        buttonjawab_b.setOnClickListener {
            ans = option_b.text.toString()

            buttonb.setBackgroundResource(R.drawable.circlegreen)
            buttonb.setTextColor(resources.getColor(R.color.colorPrimaryDark))
//
            buttona.setBackgroundResource(R.drawable.circlepurple)
            buttona.setTextColor(resources.getColor(R.color.white))

            buttonc.setBackgroundResource(R.drawable.circlepurple)
            buttonc.setTextColor(resources.getColor(R.color.white))

            buttond.setBackgroundResource(R.drawable.circlepurple)
            buttond.setTextColor(resources.getColor(R.color.white))
        }
        buttonjawab_c.setOnClickListener {
            ans = option_c.text.toString()

            buttonc.setBackgroundResource(R.drawable.circlegreen)
            buttonc.setTextColor(resources.getColor(R.color.colorPrimaryDark))
//
            buttonb.setBackgroundResource(R.drawable.circlepurple)
            buttonb.setTextColor(resources.getColor(R.color.white))

            buttona.setBackgroundResource(R.drawable.circlepurple)
            buttona.setTextColor(resources.getColor(R.color.white))

            buttond.setBackgroundResource(R.drawable.circlepurple)
            buttond.setTextColor(resources.getColor(R.color.white))
        }
        buttonjawab_d.setOnClickListener {
            ans = option_d.text.toString()

            buttond.setBackgroundResource(R.drawable.circlegreen)
            buttond.setTextColor(resources.getColor(R.color.colorPrimaryDark))
//
            buttonb.setBackgroundResource(R.drawable.circlepurple)
            buttonb.setTextColor(resources.getColor(R.color.white))

            buttonc.setBackgroundResource(R.drawable.circlepurple)
            buttonc.setTextColor(resources.getColor(R.color.white))

            buttona.setBackgroundResource(R.drawable.circlepurple)
            buttona.setTextColor(resources.getColor(R.color.white))
        }

        buttonback.setOnClickListener {
            onBackPressed()
        }

        next.setOnClickListener {
            if (ans == ""){
                Toast.makeText(this, "SELECT ONE BUTTON", Toast.LENGTH_SHORT).show()
            }
            else if (ans == answers[flag]){
                correct++
            }

            if (ans != ""){
                flag++
                ans = ""
                if (level == "1" && flag == 5){
                    marks = correct*20
                    val intent = Intent(this, Result::class.java)
                    intent.putExtra("nilai",marks)
                    intent.putExtra("level", "1")
                    startActivity(intent)
                    finish()
                }
                else if (level == "2" && flag == 10){
                    marks = correct*10
                    val intent = Intent(this, Result::class.java)
                    intent.putExtra("nilai",marks)
                    intent.putExtra("level", "2")
                    startActivity(intent)
                    finish()
                }
                else if (level== "3" && flag == 15){
                    marks = (correct*6) + 10
                    val intent = Intent(this, Result::class.java)
                    intent.putExtra("nilai",marks)
                    intent.putExtra("level", "3")
                    startActivity(intent)
                    finish()
                } else {
                    soal.text = questions[flag]
                    option_a.text = opt[flag*4]
                    option_b.text = opt[flag*4+1]
                    option_c.text = opt[flag*4+2]
                    option_d.text = opt[flag*4+3]
                    textView7.text = no++.toString()
                    clear()
                }
            }
        }

    }

    fun clear(){
        buttona.setBackgroundResource(R.drawable.circlepurple)
        buttona.setTextColor(resources.getColor(R.color.white))
//
        buttonb.setBackgroundResource(R.drawable.circlepurple)
        buttonb.setTextColor(resources.getColor(R.color.white))

        buttonc.setBackgroundResource(R.drawable.circlepurple)
        buttonc.setTextColor(resources.getColor(R.color.white))

        buttond.setBackgroundResource(R.drawable.circlepurple)
        buttond.setTextColor(resources.getColor(R.color.white))
    }

    override fun onBackPressed() {
        dialog.setContentView(R.layout.alertdialog)
        buttonYes = dialog.findViewById(R.id.button_ya)
        buttonNo = dialog.findViewById(R.id.button_tidak)
        buttonX = dialog.findViewById(R.id.button_x)
        buttonYes.setOnClickListener {
            super.onBackPressed()
            finish()
        }
        buttonNo.setOnClickListener {
            dialog.dismiss()
        }
        buttonX.setOnClickListener {
            dialog.dismiss()
        }
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }


}