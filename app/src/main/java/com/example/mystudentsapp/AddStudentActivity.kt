package com.example.mystudentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val editTextName: EditText = findViewById(R.id.editTextStudentName)
        val editTextID: EditText = findViewById(R.id.editTextStudentID)
        val buttonSave: Button = findViewById(R.id.buttonSaveStudent)

        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            val id = editTextID.text.toString()

            if (name.isBlank() || id.isBlank()) {
                Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show()
            } else {
                // Add the student to the list
                StudentsRepository.studentsList.add(Student(id, name))
                Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show()
                finish() // Close this activity and return to the list
            }
        }
    }
}
