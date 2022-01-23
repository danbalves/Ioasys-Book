package com.example.ioasysbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<AppCompatButton>(R.id.login_button)

        loginButton.setOnClickListener{
            startMenuActivity()
        }
    }

    private fun startMenuActivity(){

        val intent = Intent(this, MenuActivity::class.java)

        startActivity(intent)
    }

}