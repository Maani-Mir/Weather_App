package com.example.new_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import new_weather.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Getting the intent
        //val userMessage = intent.getStringExtra(EXTRA_MESSAGE_USERNAME)
        //val textView = findViewById<TextView>(R.id.secondActText)
        //textView.text = userMessage

    }
}