package com.decagon.feedme.view;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.decagon.feedme.R;
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        login_txt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
