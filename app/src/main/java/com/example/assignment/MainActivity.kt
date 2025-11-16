package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Paint
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val PREFS_NAME = "user_prefs"
        const val KEY_NAME = "NAME"
        const val KEY_EMAIL = "EMAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val motionLayout = findViewById<MotionLayout>(R.id.main)

        // Animation start hone ke liye thoda delay
        motionLayout.postDelayed({
            motionLayout.transitionToEnd()
        }, 300)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)
        val username = findViewById<EditText>(R.id.editTextText2) // Name field
        val email = findViewById<EditText>(R.id.editTextText) // Email field
        val password = findViewById<EditText>(R.id.editTextTextPassword)

        // ✅ Login button click
        button.setOnClickListener {
            val userText = username.text.toString().trim()
            val emailText = email.text.toString().trim()
            val passText = password.text.toString().trim()

            if (userText.isEmpty() || emailText.isEmpty() || passText.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Save name + email in SharedPreferences so profile can read later
                val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                prefs.edit()
                    .putString(KEY_NAME, userText)
                    .putString(KEY_EMAIL, emailText)
                    .apply()

                // 👉 Pehle Activity2 open karte hai (animated page) like before
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("USERNAME", userText) // Naam bhej do next activity me (as before)
                startActivity(intent)
            }
        }

        // ✅ Create account text click
        val createAccountTextView = findViewById<TextView>(R.id.textView3)
        createAccountTextView.paintFlags =
            createAccountTextView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        createAccountTextView.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }

        val createAccountTextView2 = findViewById<TextView>(R.id.textView2)
        createAccountTextView2.paintFlags =
            createAccountTextView2.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        createAccountTextView2.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }
}
