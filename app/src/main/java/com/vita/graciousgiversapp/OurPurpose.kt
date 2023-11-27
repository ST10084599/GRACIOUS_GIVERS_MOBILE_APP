package com.vita.graciousgiversapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class OurPurpose : AppCompatActivity() {

    private lateinit var btnOurPurposeBack : Button

    //Video Code
    var videoView : VideoView? = null
    var mediaController : MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_purpose)

        btnOurPurposeBack = findViewById(R.id.btnOurPurposeBack)

        btnOurPurposeBack.setOnClickListener {
            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)
        }

        val rootView = findViewById<ScrollView>(R.id.rootViewOurPurpose)

        val drawable : AnimationDrawable = rootView.background as AnimationDrawable
        drawable.setEnterFadeDuration(1500)
        drawable.setExitFadeDuration(2000)
        drawable.start()

        //Video Code
        videoView = findViewById<View>(R.id.videoView) as VideoView?

        if (mediaController == null) {
            // creating an object of media controller class
            mediaController = MediaController(this)

            // set the anchor view for the video view
            mediaController!!.setAnchorView(this.videoView)
        }

        // set the media controller for video view
        videoView!!.setMediaController(mediaController)

        // set the absolute path of the video file which is going to be played
        videoView!!.setVideoURI(
            Uri.parse("android.resource://"
                    + packageName + "/" + R.raw.gg_our_purpose))

        videoView!!.requestFocus()

        // starting the video
        videoView!!.start()

        // display a toast message
        // after the video is completed
        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed",
                Toast.LENGTH_LONG).show()
            true
        }

        // display a toast message if any
        // error occurs while playing the video
        videoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }
    }
}