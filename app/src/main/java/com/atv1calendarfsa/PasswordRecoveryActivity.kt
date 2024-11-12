package com.atv1calendarfsa

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.atv1calendarfsa.dao.UserDao

//Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class PasswordRecoveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recovery)

        //Fragment
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val logoFragment = LogoFragment()
        fragmentTransaction.add(R.id.logo_fragment_container, logoFragment)
        fragmentTransaction.commit()
        // Adicionando logs para verificar o ciclo de vida da Activity
        Log.d("LoginActivity", "onCreate chamado")


        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val newPasswordEditText: EditText = findViewById(R.id.newPasswordEditText)
        val recoverPasswordButton: Button = findViewById(R.id.recoverPasswordButton)

        recoverPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val newPassword = newPasswordEditText.text.toString()

            if (isValidEmail(email) && newPassword.isNotEmpty()) {
                val userDao = UserDao(this)
                val success = userDao.updatePassword(email, newPassword)

                if (success) {
                    Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
                    finish() // Fecha a atividade ou redireciona o usuário para a tela de login
                } else {
                    Toast.makeText(this, "Usuário não encontrado.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, insira um e-mail válido e uma nova senha.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
