package com.example.mystudentsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
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

        // Handle checkbox click
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            student.isChecked = isChecked
        }

        // Handle item click
        holder.itemView.setOnClickListener {
            val intent = Intent(context, StudentDetailsActivity::class.java).apply {
                putExtra("student_name", student.name)
                putExtra("student_id", student.id)
            }
            context.startActivity(intent)
        }
    }

        override fun getItemCount(): Int = students.size
}
