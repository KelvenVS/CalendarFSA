// UserProfileActivity.kt
package com.atv1calendarfsa

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.atv1calendarfsa.dao.UserDao
import com.atv1calendarfsa.model.User

class UserProfileActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Referências aos campos de texto
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)

        // Recebe o userId da Intent
        val userId = intent.getLongExtra("userId", -1)

        if (userId != -1L) {
            loadUserProfile(userId)
        } else {
            Toast.makeText(this, "Erro ao carregar perfil do usuário", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun loadUserProfile(userId: Long) {
        val userDao = UserDao(this)
        val user: User? = userDao.getUserById(userId) // Método que será implementado no UserDao

        user?.let {
            nameEditText.setText(it.name)
            emailEditText.setText(it.email)
            phoneEditText.setText(it.phone)
        } ?: run {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
