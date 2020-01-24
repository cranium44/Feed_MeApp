package com.decagon.feedme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.decagon.feedme.view.OnboardingActivity
import com.decagon.feedme.view.WelcomeActivity

class MainActivity : AppCompatActivity() {

    companion object{
        const val SHARED_PREF_CONFIG = "config"
        const val ONBOARDED = "onboarded"
        const val LOGGED_IN = "logged_in"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences(SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val onboarded = sharedPreferences.getBoolean(ONBOARDED, false)
        val loggedIn = sharedPreferences.getBoolean(LOGGED_IN, false)
        if (!onboarded){
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }
        if (!loggedIn){
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

    }
}
