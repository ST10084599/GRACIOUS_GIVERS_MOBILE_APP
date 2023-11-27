package com.vita.graciousgiversapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var WhatDoWeDoImg : ImageView
    private lateinit var OurPurposeImg : ImageView
    private lateinit var volunteeringImg : ImageView
    private lateinit var feedbackImg : ImageView
    private lateinit var infoIcon : ImageView



    //Gradient
    lateinit var mainLayout: RelativeLayout
    lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WhatDoWeDoImg = findViewById(R.id.WhatDoWeDoImg)
        OurPurposeImg = findViewById(R.id.OurPurposeImg)
        volunteeringImg = findViewById(R.id.volunteerImg)
        feedbackImg = findViewById(R.id.feedbackImg)
        infoIcon = findViewById(R.id.imageViewInfo)

        infoIcon.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.custom_dialog_layout_info, null)

            builder.setView(dialogView)

            builder.setPositiveButton("OK") { dialog, which ->
                dialog.dismiss() // Close the dialog
            }

            // Create and show the AlertDialog
            val dialog = builder.create()
            dialog.show()
        }


        WhatDoWeDoImg.setOnClickListener {
            val intent = Intent(this, WhatDoWeDo::class.java)
            startActivity(intent)
        }

        OurPurposeImg.setOnClickListener {
            val intent = Intent(this, OurPurpose::class.java)
            startActivity(intent)
        }

        volunteeringImg.setOnClickListener {
            val intent = Intent(this, Volunteer::class.java)
            startActivity(intent)
        }

        feedbackImg.setOnClickListener {
            val intent = Intent(this, Feedback::class.java)
            startActivity(intent)
        }

        val rootView = findViewById<RelativeLayout>(R.id.rootViewDashboard)

        val drawable : AnimationDrawable = rootView.background as AnimationDrawable
        drawable.setEnterFadeDuration(1500)
        drawable.setExitFadeDuration(2000)
        drawable.start()

        //Gradient

       /* // Initialize the AnimationDrawable
        mainLayout = findViewById(R.id.backgroundDash)
        animationDrawable = mainLayout.background as AnimationDrawable

        // Set enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000)

        // Set exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000)

    }

    override fun onResume() {
        super.onResume()
        if (animationDrawable != null && !animationDrawable.isRunning) {
            // start the animation
            animationDrawable.start()
        }

    }


    override fun onPause() {
        super.onPause()
        if (animationDrawable != null && animationDrawable.isRunning) {
            // stop the animation
            animationDrawable.stop()
        }*/
    }
}