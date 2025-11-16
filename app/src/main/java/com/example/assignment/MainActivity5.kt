package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val beachclick = findViewById<LinearLayout>(R.id.beach)
        beachclick.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        val mountainclick = findViewById<LinearLayout>(R.id.mountain)
        mountainclick.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }

        val desertclick = findViewById<LinearLayout>(R.id.desert)
        desertclick.setOnClickListener {
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        val waterfallclick = findViewById<LinearLayout>(R.id.waterfall)
        waterfallclick.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        val templeclick = findViewById<LinearLayout>(R.id.temple)
        templeclick.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }

        val campclick = findViewById<LinearLayout>(R.id.camp)
        campclick.setOnClickListener {
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }
    }
}
