package com.example.mystudentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        // Get passed data
        val studentName = intent.getStringExtra("student_name")
        val studentID = intent.getStringExtra("student_id")

        // Bind data to views
        val textViewName: TextView = findViewById(R.id.textViewStudentName)
        val textViewID: TextView = findViewById(R.id.textViewStudentID)

        textViewName.text = studentName
        textViewID.text = studentID

        // Handle Edit Button Click
        findViewById<Button>(R.id.buttonEditStudent).setOnClickListener {
            // Navigate to Edit Student Screen (to be implemented next)
        }
    }
}
