package com.atv1calendarfsa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val forgotPasswordText: TextView = findViewById(R.id.forgotPasswordText)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateLogin(username, password)) {
                // Inicia a próxima atividade caso o login seja bem-sucedido
                startActivity(Intent(this, DailyClassesActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordText.setOnClickListener {
            // Aqui, você poderia direcionar para a tela de recuperação de senha
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

    private fun validateLogin(username: String, password: String): Boolean {
        // Simulando uma validação de login, que você pode substituir por um banco de dados local
        return username == "usuario" && password == "senha123"
    }


}
