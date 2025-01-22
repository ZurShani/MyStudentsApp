package com.example.mystudentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentName = intent.getStringExtra("student_name")
        val studentID = intent.getStringExtra("student_id")

        val editTextName: EditText = findViewById(R.id.editTextStudentName)
        val editTextID: EditText = findViewById(R.id.editTextStudentID)

        editTextName.setText(studentName)
        editTextID.setText(studentID)

        findViewById<Button>(R.id.buttonSaveChanges).setOnClickListener {
            val newName = editTextName.text.toString()
            val newID = editTextID.text.toString()

            // Update student details in repository
            StudentsRepository.studentsList.find { it.id == studentID }?.apply {
                name = newName
                id = newID
            }
            finish() // Return to previous screen
        }

        findViewById<Button>(R.id.buttonDeleteStudent).setOnClickListener {
            StudentsRepository.studentsList.removeAll { it.id == studentID }
            finish() // Return to previous screen
        }
    }
}
