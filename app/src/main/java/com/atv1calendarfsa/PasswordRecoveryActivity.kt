package com.atv1calendarfsa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PasswordRecoveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recovery)

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val recoverPasswordButton: Button = findViewById(R.id.recoverPasswordButton)

        recoverPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if (isValidEmail(email)) {
                Toast.makeText(this, getString(R.string.password_recovery_success), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.password_recovery_error), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
