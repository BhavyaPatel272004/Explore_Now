package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        val upiLayout = findViewById<LinearLayout>(R.id.upiLayout)
        val cardLayout = findViewById<LinearLayout>(R.id.cardLayout)
        val netbankingLayout = findViewById<LinearLayout>(R.id.netbankingLayout)
        val walletLayout = findViewById<LinearLayout>(R.id.walletLayout)
        val btnPayNow = findViewById<Button>(R.id.btnPayNow)

        upiLayout.setOnClickListener {
            Toast.makeText(this, "UPI Selected (Google Pay / PhonePe)", Toast.LENGTH_SHORT).show()
        }
        cardLayout.setOnClickListener {
            Toast.makeText(this, "Card Payment Selected", Toast.LENGTH_SHORT).show()
        }
        netbankingLayout.setOnClickListener {
            Toast.makeText(this, "Net Banking Selected", Toast.LENGTH_SHORT).show()
        }
        walletLayout.setOnClickListener {
            Toast.makeText(this, "Wallet Payment Selected", Toast.LENGTH_SHORT).show()
        }

        btnPayNow.setOnClickListener {
            Toast.makeText(this, "Processing Payment...", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity136::class.java)
            startActivity(intent)
        }
    }
}
