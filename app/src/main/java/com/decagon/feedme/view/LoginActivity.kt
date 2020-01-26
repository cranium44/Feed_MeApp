package com.decagon.feedme.view

import android.content.Context
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

        val sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        login_btn.setOnClickListener {
            val email = email_input.editText?.text.toString().trim()
            val password = password_input.editText?.text.toString().trim()
            val success = repository.checkLogin(email, password)

            if (success){
                editor.putBoolean(MainActivity.LOGGED_IN, true)
                editor.apply()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Login Failed please try again", Toast.LENGTH_SHORT)
                    .show()

            }

        }


        sign_in_txt.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}
