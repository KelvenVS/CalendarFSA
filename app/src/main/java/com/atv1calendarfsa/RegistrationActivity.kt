package com.atv1calendarfsa

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Referência aos campos
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val courseSpinner: Spinner = findViewById(R.id.courseSpinner)
        val registerButton: Button = findViewById(R.id.registerButton)

        // Adicionar cursos ao Spinner
        val courses = arrayOf("Matemática", "História", "Química", "Física", "Biologia", "Literatura")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        courseSpinner.adapter = adapter

        // Lidar com o clique no botão de cadastro
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val email = emailEditText.text.toString()
            val selectedCourse = courseSpinner.selectedItem.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()) {
                // Simular salvamento dos dados
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
                // Limpar os campos após o cadastro
                usernameEditText.text.clear()
                passwordEditText.text.clear()
                nameEditText.text.clear()
                phoneEditText.text.clear()
                emailEditText.text.clear()
                courseSpinner.setSelection(0)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
