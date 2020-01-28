package com.decagon.feedme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.decagon.feedme.view.OnboardingActivity
import com.decagon.feedme.view.WelcomeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val SHARED_PREF_CONFIG = "config"
        const val ONBOARDED = "onboarded"
        const val LOGGED_IN = "logged_in"
        const val USER_NAME = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavWithController()

        val sharedPreferences = getSharedPreferences(SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val onBoarded = sharedPreferences.getBoolean(ONBOARDED, false)
        val loggedIn = sharedPreferences.getBoolean(LOGGED_IN, false)
        if (!onBoarded){
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }
        if (!loggedIn){
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun setupBottomNavWithController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)
    }
}
