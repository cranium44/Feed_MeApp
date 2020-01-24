package com.decagon.feedme.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.decagon.feedme.models.OnboardingEnum

class OnBoardingAdapter(var context: Context): PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val pagerEnum = OnboardingEnum.values()[position]
        val layout = LayoutInflater.from(context).inflate(pagerEnum.onboardingScreenId, container, false)
        container.addView(layout)
        return layout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return OnboardingEnum.values().size
    }

}