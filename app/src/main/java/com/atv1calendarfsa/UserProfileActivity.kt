// UserProfileActivity.kt
package com.atv1calendarfsa

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.atv1calendarfsa.dao.UserDao
import com.atv1calendarfsa.model.User

//Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class UserProfileActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var saveButton: Button
    private var userId: Long = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        //Fragment
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val logoFragment = LogoFragment()
        fragmentTransaction.add(R.id.logo_fragment_container, logoFragment)
        fragmentTransaction.commit()
        // Adicionando logs para verificar o ciclo de vida da Activity
        Log.d("LoginActivity", "onCreate chamado")

        // Referências aos campos de texto
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        saveButton = findViewById(R.id.saveButton)

        // Recebe o userId da Intent
        val userId = intent.getLongExtra("userId", -1)

        if (userId != -1L) {
            loadUserProfile(userId)
        } else {
            Toast.makeText(this, "Erro ao carregar perfil do usuário", Toast.LENGTH_SHORT).show()
            finish()
        }

        saveButton.setOnClickListener {
            updateUserName(userId)
            updateEmail(userId)
            updatePhone(userId)
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

    private fun updateUserName(userId: Long) {
        if (userId == -1L) {
            Toast.makeText(this, "Erro ao atualizar perfil do usuário", Toast.LENGTH_SHORT).show()
            return
        }

        val newName = nameEditText.text.toString()
        val userDao = UserDao(this)
        val success = userDao.updateName(userId, newName)

        if (success) {
            Toast.makeText(this, "Dados atualizado com sucesso!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Falha ao atualizar o nome", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateEmail(userId: Long) {
        if (userId == -1L) {
            Toast.makeText(this, "Erro ao atualizar perfil do usuário", Toast.LENGTH_SHORT).show()
            return
        }

        val newEmail = emailEditText.text.toString()
        val userDao = UserDao(this)
        val success = userDao.updateEmail(userId, newEmail)

        if (success) {
            Toast.makeText(this, "Dados atualizado com sucesso!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Falha ao atualizar o email", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updatePhone(userId: Long) {
        if (userId == -1L) {
            Toast.makeText(this, "Erro ao atualizar perfil do usuário", Toast.LENGTH_SHORT).show()
            return
        }

        val newPhone = phoneEditText.text.toString()
        val userDao = UserDao(this)
        val success = userDao.updatePhone(userId, newPhone)

        if (success) {
            Toast.makeText(this, "Dados atualizado com sucesso!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Falha ao atualizar o Telefone", Toast.LENGTH_SHORT).show()
        }
    }
}
