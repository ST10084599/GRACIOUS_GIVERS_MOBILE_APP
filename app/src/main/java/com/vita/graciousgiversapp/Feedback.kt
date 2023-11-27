package com.vita.graciousgiversapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView

class Feedback : AppCompatActivity() {

    private lateinit var btnFeedbackBack : Button
    private lateinit var edEmail : EditText
    private lateinit var edDescribeExp : EditText
    private lateinit var edBetterExp : EditText
    private lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        btnFeedbackBack = findViewById(R.id.btnFeedbackBack)
        edDescribeExp = findViewById(R.id.edDescribeExp)
        edBetterExp = findViewById(R.id.edBetterExp)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnFeedbackBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
            btnSubmit.setOnClickListener {
                sendEmail()
            }

        val rootView = findViewById<ScrollView>(R.id.rootViewFeedback)

        val drawable : AnimationDrawable = rootView.background as AnimationDrawable
        drawable.setEnterFadeDuration(1500)
        drawable.setExitFadeDuration(2000)
        drawable.start()
        }//end onCreate


        //send email function
        private fun sendEmail() {
            //user inputs
            val describeExperience = edDescribeExp.text.toString()
            val betterExperience = edDescribeExp.text.toString()

            //Email Contents
            val recipientEmail = "saivenbisetty@gmail.com" //change to gracious givers email //hi saiven
            val subject = "FEEDBACK INFO: " //enter user name from db here
            // change message to suit the user input values on the page
            val message= "------------------------------------------------------------\nHow Would You Describe Your \nExperience With Us?\n------------------------------------------------------------\n" +
                    describeExperience+
                    "\n------------------------------------------------------------\nHow Can We Better Your Experience?\n------------------------------------------------------------\n" +
                    betterExperience


            //Call emailSender class
            EmailSender.sendEmail(this, recipientEmail, subject, message)
        }
    }