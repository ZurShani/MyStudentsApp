package com.example.mystudentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.CheckBox

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentName = intent.getStringExtra("student_name")
        val studentID = intent.getStringExtra("student_id")
        val student = StudentsRepository.studentsList.find { it.id == studentID }

        val editTextName: EditText = findViewById(R.id.editTextStudentName)
        val editTextID: EditText = findViewById(R.id.editTextStudentID)
        val checkBoxEdit: CheckBox = findViewById(R.id.checkBoxEdit)
        val buttonSaveChanges: Button = findViewById(R.id.buttonSaveChanges)
        val buttonDeleteStudent: Button = findViewById(R.id.buttonDeleteStudent)

        // Populate fields
        editTextName.setText(student?.name)
        editTextID.setText(student?.id)
        checkBoxEdit.isChecked = student?.isChecked == true

        // Handle Save Changes
        buttonSaveChanges.setOnClickListener {
            val newName = editTextName.text.toString()
            val newID = editTextID.text.toString()
            val newChecked = checkBoxEdit.isChecked

            student?.apply {
                name = newName
                id = newID
                isChecked = newChecked
            }

            finish() // Return to previous screen
        }

        // Handle Delete Student
        buttonDeleteStudent.setOnClickListener {
            StudentsRepository.studentsList.removeAll { it.id == studentID }
            finish() // Return to previous screen
        }
    }
}