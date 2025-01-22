package com.example.mystudentsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        val students = mutableListOf(
            Student("1", "John Doe"),
            Student("2", "Jane Smith"),
            Student("3", "Alice Johnson")
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentsAdapter(students) { student ->
            // Handle row click (e.g., navigate to StudentDetailsActivity)
        }
    }
}
