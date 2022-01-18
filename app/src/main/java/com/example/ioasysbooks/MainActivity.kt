package com.example.ioasysbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<TextInputLayout>(R.id.input_email)
        val passwordInput = findViewById<TextInputLayout>(R.id.input_password)
        val loginButton = findViewById<AppCompatButton>(R.id.login_button)
        val errorMessage = findViewById<TextView>(R.id.error_message)

    }


}