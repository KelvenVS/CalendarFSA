package com.atv1calendarfsa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DailyClassesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_classes)

        // Referências para os TextViews que exibem as aulas
        val class1Text: TextView = findViewById(R.id.class1Text)
        val class2Text: TextView = findViewById(R.id.class2Text)
        val class3Text: TextView = findViewById(R.id.class3Text)
        val class4Text: TextView = findViewById(R.id.class4Text)

        // Simulando as aulas do dia
        val dailyClasses = listOf("Matemática", "História", "Química", "Física")

        // Atribuindo as aulas aos TextViews
        class1Text.text = dailyClasses.getOrNull(0) ?: getString(R.string.no_class)
        class2Text.text = dailyClasses.getOrNull(1) ?: getString(R.string.no_class)
        class3Text.text = dailyClasses.getOrNull(2) ?: getString(R.string.no_class)
        class4Text.text = dailyClasses.getOrNull(3) ?: getString(R.string.no_class)
    }
}
