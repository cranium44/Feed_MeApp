package com.decagon.feedme.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.decagon.feedme.MainActivity
import com.decagon.feedme.R
import com.decagon.feedme.controllers.UserRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var repository = UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val sharedPreferences =
            getSharedPreferences(MainActivity.SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()



        sign_up_btn.setOnClickListener {
            val fname = first_name_input.editText?.text.toString().trim()
            val lname = last_name_input.editText?.text.toString().trim()
            val email = email_input.editText?.text.toString().trim()
            val password = validatePassword()


            if (password.isEmpty()){
                Toast.makeText(
                    this,
                    "Passwords Do Not Match",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val success = repository.createUser(email, password)
            if(success){
                editor.putString(MainActivity.USER_NAME, "$fname $lname")
                editor.putBoolean(MainActivity.LOGGED_IN, true)
                editor.apply()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }

        }
    }

    private fun validatePassword(): String {
        val pass = password_input.editText?.text.toString().trim()
        val conf = confirm_password_input.editText?.text.toString().trim()

        if (conf.isEmpty() || pass.isEmpty()) {
            return ""
        } else {
            if (conf == pass) {
                return conf
            }
            return ""
        }
    }


}
