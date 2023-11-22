package com.example.bebanggis

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nilai = intent.getIntExtra("nilai", 0)
        val level = intent.getStringExtra("level")

        if (nilai <= 60){
            predikat.text = "Your quiz score is still too low :("
        }
        else {
            predikat.text = "Excellent Work! Your quiz score..."
        }

        when (level) {
            "1" -> {
                textlevel.text = "Beginner Level"
            }
            "2" -> {
                textlevel.text = "Advanced Level"
            }
            else -> {
                textlevel.text = "Professional Level"
            }
        }

        val hasil = nilai.toString()

        grade.text = "$hasil/100"
        bagikan.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Wow, my score was quizzed by Bendaggis $hasil, Come on, download the application now on the Play Store!")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Share to...")
            startActivity(shareIntent)
        }

        back.setOnClickListener {
            finish()
        }

    }
}
