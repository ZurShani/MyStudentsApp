package com.example.mystudentsapp

import android.content.Intent
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

        findViewById<Button>(R.id.buttonEditStudent).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java).apply {
                putExtra("student_name", studentName)
                putExtra("student_id", studentID)
            }
            startActivity(intent)
        }

    }
}
