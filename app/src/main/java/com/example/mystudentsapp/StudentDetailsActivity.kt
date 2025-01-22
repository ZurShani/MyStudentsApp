package com.example.mystudentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.CheckBox


class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentName = intent.getStringExtra("student_name")
        val studentID = intent.getStringExtra("student_id")
        val student = StudentsRepository.studentsList.find { it.id == studentID }

        val textViewName: TextView = findViewById(R.id.textViewStudentName)
        val textViewID: TextView = findViewById(R.id.textViewStudentID)
        val checkBoxDetails: CheckBox = findViewById(R.id.checkBoxDetails)

        textViewName.text = student?.name
        textViewID.text = student?.id
        checkBoxDetails.isChecked = student?.isChecked == true

        findViewById<Button>(R.id.buttonEditStudent).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java).apply {
                putExtra("student_name", studentName)
                putExtra("student_id", studentID)
            }
            startActivity(intent)
        }

    }
}
