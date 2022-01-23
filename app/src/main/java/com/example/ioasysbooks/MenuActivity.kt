package com.example.ioasysbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val logOutButton = findViewById<ImageButton>(R.id.logOutButton)

        logOutButton.setOnClickListener {
            startMainActivity()
        }
    }

    private fun startMainActivity() {

        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)

    }
}