package com.decagon.feedme.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.feedme.R
import com.decagon.feedme.controllers.OnBoardingAdapter
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        view_pager.adapter = OnBoardingAdapter(this)
    }
}