package com.vita.graciousgiversapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView

class Volunteer : AppCompatActivity() {

    private lateinit var btnVolunteerBack : Button
    private lateinit var edName : EditText
    private lateinit var edAge : EditText
    private lateinit var edDate : EditText
    private lateinit var edVolunteerInformation : EditText
    private lateinit var btnSubmit : Button
    private lateinit var btnOurPurposeVolunteer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)

        btnVolunteerBack = findViewById(R.id.btnVolunteerBack)
        edName = findViewById(R.id.edName)
        edAge = findViewById(R.id.edAge)
        edDate = findViewById(R.id.edDate)
        edVolunteerInformation = findViewById(R.id.edVolunteerInformation)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnOurPurposeVolunteer = findViewById(R.id.btnPurposeVolunteering)

        btnVolunteerBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnSubmit.setOnClickListener {
            sendEmail()
        }

        btnOurPurposeVolunteer.setOnClickListener {
            val intent = Intent(this, OurPurpose::class.java)
            startActivity(intent)
        }

        val rootView = findViewById<ScrollView>(R.id.rootViewVolunteer)

        val drawable : AnimationDrawable = rootView.background as AnimationDrawable
        drawable.setEnterFadeDuration(1500)
        drawable.setExitFadeDuration(2000)
        drawable.start()

    }//end onCreate

    //send email function
    private fun sendEmail() {
        //user inputs
        val name = edName.text.toString()
        val age = edAge.text.toString()
        val date = edDate.text.toString()
        val volunteerInfo = edVolunteerInformation.text.toString()


        //Email Contents
        val recipientEmail = "saivenbisetty@gmail.com" //change to gracious givers email //hi saiven //Hi Ayuri
        val subject = "Volunteer Information: $name $date"
        // change message to suit the user input values on the page
        val message = "--------------------------------------------------------\nVolunteer Personal Information\n--------------------------------------------------------\n" +
                "Name: $name " +
                "\nAge: $age " +
                "\nDate: $date \n" +
                "\n--------------------------------------------------------\nWhy do you want to volunteer?\n--------------------------------------------------------\n $volunteerInfo"

        //Call emailSender class
        EmailSender.sendEmail(this, recipientEmail, subject, message)
    }
}