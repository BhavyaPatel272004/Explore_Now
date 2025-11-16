package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        // Profile name/email TextViews from layout
        val profileName = findViewById<TextView>(R.id.profileName)
        val profileEmail = findViewById<TextView>(R.id.profileEmail)

        // Try to get from Intent first (if caller passed them)
        val nameFromIntent = intent.getStringExtra("NAME")
        val emailFromIntent = intent.getStringExtra("EMAIL")

        // If intent doesn't have values, fallback to SharedPreferences
        val prefs = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE)
        val name = nameFromIntent ?: prefs.getString(MainActivity.KEY_NAME, "User")
        val email = emailFromIntent ?: prefs.getString(MainActivity.KEY_EMAIL, "example@gmail.com")

        // Set the profile texts
        profileName.text = name
        profileEmail.text = email

        // Option buttons (existing)
        val editProfile = findViewById<TextView>(R.id.editProfile)
        val settings = findViewById<TextView>(R.id.settings)
        val helpCenter = findViewById<TextView>(R.id.helpCenter)
        val logout = findViewById<TextView>(R.id.logout)

        // Click listeners for each option
        editProfile.setOnClickListener {
            Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
            // Example: startActivity(Intent(this, EditProfileActivity::class.java))
        }

        settings.setOnClickListener {
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
            // Example: startActivity(Intent(this, SettingsActivity::class.java))
        }

        helpCenter.setOnClickListener {
            Toast.makeText(this, "Help Center Clicked", Toast.LENGTH_SHORT).show()
            // Example: startActivity(Intent(this, HelpCenterActivity::class.java))
        }

        logout.setOnClickListener {
            // Clear saved user data on logout (optional)
            prefs.edit().remove(MainActivity.KEY_NAME).remove(MainActivity.KEY_EMAIL).apply()
            Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show()
            // Navigate back to login screen
            val intent = Intent(this, MainActivity::class.java)
            // finish current profile activity and clear activity stack if required
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
