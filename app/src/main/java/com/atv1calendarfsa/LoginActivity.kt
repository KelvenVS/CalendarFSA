package com.atv1calendarfsa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.atv1calendarfsa.dao.UserDao

//Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val forgotPasswordText: TextView = findViewById(R.id.forgotPasswordText)

        //Fragment
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val logoFragment = LogoFragment()
        fragmentTransaction.add(R.id.logo_fragment_container, logoFragment)
        fragmentTransaction.commit()
        // Adicionando logs para verificar o ciclo de vida da Activity
        Log.d("LoginActivity", "onCreate chamado")

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validar login e obter o ID do usuário
            val userDao = UserDao(this)
            val user = userDao.getUser(username, password)

            if (user != null) {
                // Inicia a próxima atividade com o ID do usuário caso o login seja bem-sucedido
                val intent = Intent(this, DailyClassesActivity::class.java).apply {
                    putExtra("userId", user.id)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordText.setOnClickListener {
            // Direcionar para a tela de recuperação de senha
            startActivity(Intent(this, PasswordRecoveryActivity::class.java))
        }

        // Botão para acessar a tela de cadastro
        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            // Iniciar a RegistrationActivity
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
