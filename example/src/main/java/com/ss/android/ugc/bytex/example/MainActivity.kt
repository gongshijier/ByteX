package com.ss.android.ugc.bytex.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ss.android.ugc.bytex.example.coverage.CoverageReportTask

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.main_text)
        // Handle coverage log info, send to the server
        CoverageReportTask.init()

        textView.setOnClickListener {
            clickText()
        }
    }

    private fun clickText() {
        delaySec()
        textView.text = "Hello World!"
    }

    private fun delaySec() {
        Thread.sleep(3000)
    }
}
