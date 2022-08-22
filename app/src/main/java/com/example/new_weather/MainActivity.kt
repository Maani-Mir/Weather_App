package com.example.new_weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import new_weather.R

//import new_weather.R


const val EXTRA_MESSAGE_USERNAME = "username.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.d("MainActivity", "before listener")

        val textForgotPass = findViewById<View>(R.id.textForgotPassword) as TextView

        //click listener in kotlin
        textForgotPass.setOnClickListener(View.OnClickListener {

            //Log.d("MainActivity", "in the listener")
            Toast.makeText(this,"Oh no, too bad you can't change it :p", Toast.LENGTH_SHORT).show()

           // fun onClick(v: View?) {
           //     Log.d("MainActivity", "in the onClick")
                //Logic
           // }

        })

        val loginButton = findViewById<View>(R.id.buttonLogin) as Button

        loginButton.setOnClickListener {

            launchSecondActivity()

        }

    }

    fun launchSecondActivity() {
        val editUsername = findViewById<View>(R.id.editTextName) as EditText
        val messageUsername = editUsername.text.toString()
        val editPassword = findViewById<View>(R.id.editTextPassword) as EditText
        val messagePass = editPassword.text.toString()

        Log.d("mainactivity", messageUsername)
        Log.d("mainactivity", messagePass)

        if(messageUsername == "salman.arif@gmail.com" && messagePass == "Test1234")
        {
            val intent = Intent (this, SecondActivity::class.java).apply {

            }
            startActivity(intent)
        }
        else
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()

    }


}