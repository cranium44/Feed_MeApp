package com.decagon.feedme.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.feedme.MainActivity
import com.decagon.feedme.R
import com.decagon.feedme.controllers.OnBoardingAdapter
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        view_pager.adapter = OnBoardingAdapter(this)
        indicator.setViewPager(view_pager)

        on_nxt_button.setOnClickListener {
            setOnboarded()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setOnboarded() {
        val sharedPreferences =
            getSharedPreferences(MainActivity.SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(MainActivity.ONBOARDED, true).apply()
    }


}