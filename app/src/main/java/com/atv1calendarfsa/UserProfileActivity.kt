package com.atv1calendarfsa

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val saveButton: Button = findViewById(R.id.saveButton)

        // Carrega os dados do perfil do usuário
        val sharedPreferences = getSharedPreferences("userProfile", Context.MODE_PRIVATE)
        nameEditText.setText(sharedPreferences.getString("name", ""))
        emailEditText.setText(sharedPreferences.getString("email", ""))
        phoneEditText.setText(sharedPreferences.getString("phone", ""))

        // Salva as informações quando o botão é pressionado
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()

            // Salva os dados em SharedPreferences
            with(sharedPreferences.edit()) {
                putString("name", name)
                putString("email", email)
                putString("phone", phone)
                apply()
            }

            Toast.makeText(this, getString(R.string.save_success), Toast.LENGTH_SHORT).show()
        }
    }
}
