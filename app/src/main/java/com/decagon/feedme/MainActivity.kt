package com.decagon.feedme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.decagon.feedme.view.OnboardingActivity

class MainActivity : AppCompatActivity() {

    companion object{
        const val SHARED_PREF_CONFIG = "config"
        const val ONBOARDED = "onboarded"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences(SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val onboarded = sharedPreferences.getBoolean(ONBOARDED, false)
        if (!onboarded){
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }

    }
}
