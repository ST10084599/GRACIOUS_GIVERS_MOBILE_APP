package com.vita.graciousgiversapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object EmailSender {
    fun sendEmail(context: Context, recipEmail: String, emailSubject: String, emailMessage: String)
    {
        //Error Handling
        try{
            val emailIntent = Intent(Intent.ACTION_SEND)
            //Indicates Data field is for sending email
            emailIntent.data = Uri.parse("mailto:")
            //Set MIME type for email messages
            emailIntent.type = "message/rfc882"
            //Recipient EMail address
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipEmail))
            //Email Subject
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
            //Email body
            emailIntent.putExtra(Intent.EXTRA_TEXT, emailMessage)

            //Check if email client is available
            if (emailIntent.resolveActivity(context.packageManager) != null){
                context.startActivity(Intent.createChooser(emailIntent, "Send Email"))
            } else {
                Toast.makeText(context, "No email client found.", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception){
            Toast.makeText(context, "Error sending email.", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

}