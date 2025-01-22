package com.example.mystudentsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentsAdapter(
    private val context: Context,
    private val students: List<Student>,
    private val onRowClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val idTextView: TextView = itemView.findViewById(R.id.textViewID)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val pictureImageView: ImageView = itemView.findViewById(R.id.imageViewStudentPic) // Bind ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]

        holder.nameTextView.text = student.name
        holder.idTextView.text = student.id
        holder.checkBox.isChecked = student.isChecked
        holder.pictureImageView.setImageResource(R.drawable.ic_student)

        // Handle item click
        holder.itemView.setOnClickListener {
            onRowClick(student) // Call the lambda function passed from the activity
        }
    }

    override fun getItemCount(): Int = students.size
}
