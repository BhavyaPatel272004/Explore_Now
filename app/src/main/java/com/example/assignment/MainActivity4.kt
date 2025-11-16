package com.example.assignment

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.R.id

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val searchBar = findViewById<EditText>(R.id.searchBar)
        val searchIcon = findViewById<ImageView>(R.id.searchIcon)
        val greeting = findViewById<TextView>(R.id.greetingText)


        val clickseeall = findViewById<TextView>(id.SeeAll)
        clickseeall.paintFlags = clickseeall.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        clickseeall.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

        val clickexplore = findViewById<TextView>(id.explore)
        clickexplore.paintFlags = clickseeall.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        clickexplore.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

        val beachceta = findViewById<LinearLayout>(id.beachCategory)
        beachceta.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }


        val mountainceta = findViewById<LinearLayout>(id.mountainCategory)
        mountainceta.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }


        val desertceta = findViewById<LinearLayout>(id.desertCategory)
        desertceta.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }


        val waterfallceta = findViewById<LinearLayout>(id.waterfallCategory)
        waterfallceta.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
        val templeceta = findViewById<LinearLayout>(id.templeCategory)
        templeceta.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }




        val profilepic = findViewById<ImageView>(id.profile)
        profilepic.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        val userName = intent.getStringExtra("USERNAME") ?: "Explorer"
        greeting.text = "Hello, $userName 👋"

        searchIcon.setOnClickListener {
            val query = searchBar.text.toString().trim().lowercase()

            when {
                query.contains("beach") -> startActivity(Intent(this, MainActivity7::class.java))
                query.contains("mountain") -> startActivity(Intent(this, MainActivity8::class.java))
                query.contains("temple") -> startActivity(Intent(this, MainActivity11::class.java))
                query.contains("desert") -> startActivity(Intent(this, MainActivity9::class.java))
                query.contains("waterfall") -> startActivity(Intent(this, MainActivity10::class.java))
                query.contains("camp") -> startActivity(Intent(this, MainActivity12::class.java))
                else -> Toast.makeText(this, "No destination found for '$query'", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
