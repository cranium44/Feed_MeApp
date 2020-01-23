package com.decagon.feedme.controllers

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter

class OnBoardingAdapter(context: Context): PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return 0
    }
}