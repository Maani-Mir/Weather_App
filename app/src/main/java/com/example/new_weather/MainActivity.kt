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


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;


import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import java.util.*


import new_weather.R
import android.R




//import new_weather.R


const val EXTRA_MESSAGE_USERNAME = "username.MESSAGE"

class MainActivity : AppCompatActivity() {

    private var loginViewModel: LoginViewModel? = null

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(new_weather.R.layout.activity_main)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView<ViewDataBinding>(
            this@MainActivity,
            new_weather.R.layout.activity_main
        )

        binding.setLifecycleOwner(this)

        binding.setLoginViewModel(loginViewModel)

        loginViewModel.getUser().observe(this, object : Observer<LoginUser?>() {
            fun onChanged(@Nullable loginUser: LoginUser) {
                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address")
                    binding.txtEmailAddress.requestFocus()
                } else if (!loginUser.isEmailValid) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address")
                    binding.txtEmailAddress.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password")
                    binding.txtPassword.requestFocus()
                } else if (!loginUser.isPasswordLengthGreaterThan5) {
                    binding.txtPassword.setError("Enter at least 6 Digit password")
                    binding.txtPassword.requestFocus()
                } else {
                    binding.lblEmailAnswer.setText(loginUser.strEmailAddress)
                    binding.lblPasswordAnswer.setText(loginUser.strPassword)
                }
            }
        })












        //Log.d("MainActivity", "before listener")

        val textForgotPass = findViewById<View>(new_weather.R.id.textForgotPassword) as TextView

        //click listener in kotlin
        textForgotPass.setOnClickListener(View.OnClickListener {

            //Log.d("MainActivity", "in the listener")
            Toast.makeText(this,"Oh no, too bad you can't change it :p", Toast.LENGTH_SHORT).show()

           // fun onClick(v: View?) {
           //     Log.d("MainActivity", "in the onClick")
                //Logic
           // }

        })

        val loginButton = findViewById<View>(new_weather.R.id.buttonLogin) as Button

        loginButton.setOnClickListener {

            launchSecondActivity()

        }

    }

    fun launchSecondActivity() {
        val editUsername = findViewById<View>(new_weather.R.id.editTextName) as EditText
        val messageUsername = editUsername.text.toString()
        val editPassword = findViewById<View>(new_weather.R.id.editTextPassword) as EditText
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