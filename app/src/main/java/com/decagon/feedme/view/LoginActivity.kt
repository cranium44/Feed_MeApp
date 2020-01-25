package com.decagon.feedme.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.decagon.feedme.MainActivity
import com.decagon.feedme.R
import com.decagon.feedme.controllers.UserRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val repository = UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            val email = email_input.editText?.text.toString().trim()
            val password = password_input.editText?.text.toString().trim()
            val success = repository.checkLogin(email, password)

            if (success){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Login Failed please try again", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }
}
