package com.example.cse223_ca1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class moreimg : AppCompatActivity() {
    lateinit var b1: RatingBar
    lateinit var b2: RatingBar
    lateinit var b3: RatingBar
    lateinit var fb: RatingBar
    lateinit var btt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moreimg)

        b1=findViewById(R.id.ratingBar)
        b2=findViewById(R.id.ratingBar2)
        b3=findViewById(R.id.ratingBar3)
        fb=findViewById(R.id.ratingBar4)
        btt=findViewById(R.id.custbtn)

        b1.setOnRatingBarChangeListener { ratingBar, fl, b ->
            val r=(b1.rating+b2.rating+b3.rating)/3
            fb.rating=r
        }
        b2.setOnRatingBarChangeListener { ratingBar, fl, b ->
            val r=(b1.rating+b2.rating+b3.rating)/3
            fb.rating=r
        }
        b3.setOnRatingBarChangeListener { ratingBar, fl, b ->
            val r=(b1.rating+b2.rating+b3.rating)/3
            fb.rating=r
        }

        btt.setOnClickListener {
            Toast(this).showCustomToast ("Hello! This is a custom Toast!", this)
            /*val vg: ViewGroup?=findViewById(R.id.customToast)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast,vg)
            val txv=findViewById<TextView>(R.id.customm)
            txv.text="Custom Text Notification Redirecting you to next page"
            val toast = Toast(applicationContext)

            toast.setGravity(Gravity.CENTER_VERTICAL, 0 , 100)
            toast.duration = Toast.LENGTH_LONG
            toast.setView(layout)
            toast.show()*/
        }
    }
    fun Toast.showCustomToast(message: String, activity: Activity)
    {
        val layout = activity.layoutInflater.inflate (
            R.layout.custom_toast,
            activity.findViewById(R.id.customToast)
        )

        // set the text of the TextView of the message
        val textView = layout.findViewById<TextView>(R.id.customm)
        textView.text = message

        // use the application extension function
        this.apply {
            setGravity(Gravity.BOTTOM, 0, 40)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}