package com.example.mystudentsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.DividerItemDecoration


class StudentsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Use a shared repository for data
        val students = StudentsRepository.studentsList

        val adapter = StudentsAdapter(this,students) { student ->
            // Handle row click: Navigate to details screen (to be implemented later)
        }
        recyclerView.adapter = adapter

        // FAB to add a new student
        val fabAddStudent: FloatingActionButton = findViewById(R.id.fabAddStudent)
        fabAddStudent.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        // Refresh the list when returning to this activity
        findViewById<RecyclerView>(R.id.recyclerViewStudents).adapter?.notifyDataSetChanged()
    }
}
