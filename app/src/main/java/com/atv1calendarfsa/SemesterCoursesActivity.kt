package com.atv1calendarfsa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SemesterCoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semester_courses)

        val recyclerView: RecyclerView = findViewById(R.id.semesterCoursesRecyclerView)

        // Simulando uma lista de cursos
        val courses = listOf("Matemática", "História", "Química", "Física", "Biologia", "Literatura")

        // Configurando o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CourseAdapter(courses)
    }
}
