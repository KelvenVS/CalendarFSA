// DailyClassesActivity.kt
package com.atv1calendarfsa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DailyClassesActivity : AppCompatActivity() {

    private var userId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_classes)

        // Recupera o userId da Intent
        userId = intent.getLongExtra("userId", -1)

        // Configura o botão para abrir o perfil do usuário
        val viewProfileButton: Button = findViewById(R.id.viewProfileButton)
        viewProfileButton.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java).apply {
                putExtra("userId", userId)
            }
            startActivity(intent)
        }
    }
}
