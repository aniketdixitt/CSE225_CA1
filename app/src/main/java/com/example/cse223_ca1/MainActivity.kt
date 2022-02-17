package com.example.cse223_ca1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import java.util.zip.Inflater


class MainActivity : AppCompatActivity() {
    lateinit var tlb:androidx.appcompat.widget.Toolbar
    lateinit var btn:Button
    private var i = 0
    lateinit var pgbar:ProgressBar
    lateinit var txt:TextView
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tlb=findViewById(R.id.toolbar)
        btn=findViewById(R.id.button2)
        pgbar=findViewById(R.id.progress_Bar)
        txt=findViewById(R.id.text_view)

        tlb.setTitle("   CA1")
        tlb.setBackgroundColor(Color.YELLOW)
        tlb.setLogo(R.drawable.ic_baseline_all_inclusive_24)
        setSupportActionBar(tlb)
        tlb.setNavigationOnClickListener {
            Toast.makeText(this,"By Aniket Dixit",Toast.LENGTH_LONG).show()
        }

        btn.setOnClickListener {

            pgbar.visibility=View.VISIBLE
            i=pgbar.progress
            Thread(Runnable {
                while (i<100)
                {
                    i+=1
                    handler.post(Runnable {
                        pgbar.progress=i
                        txt.text=i.toString()+"%"
                    })
                    try{
                        Thread.sleep(50)
                    }catch (e: InterruptedException){
                        e.printStackTrace()
                    }
                }
                pgbar.visibility=View.INVISIBLE
                txt.visibility=View.INVISIBLE
                var intent=Intent(this,moreimg::class.java)
                startActivity(intent)

            }).start()


        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_items,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id:Int= item.itemId
        if(id==R.id.setting)
        {
            Toast.makeText(applicationContext, "Settings", Toast.LENGTH_LONG).show()
            return true
        }
        else if(id==R.id.fdbk)
        {
            Toast.makeText(applicationContext, "Feedback", Toast.LENGTH_LONG).show()
            return true
        }
        else if(id==R.id.aboutus)
        {
            Toast.makeText(applicationContext, "About us", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}