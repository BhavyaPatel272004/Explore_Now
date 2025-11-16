package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        motionLayout.post { motionLayout.transitionToEnd() }

        val button = findViewById<Button>(R.id.getstart)
        val userName = intent.getStringExtra("USERNAME") // 👈 receive name here

        // Jab "Get Started" dabaye → Activity4 open kare + name pass kare
        button.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("USERNAME", userName)
            startActivity(intent)
        }
    }
}
