package com.decagon.feedme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.Navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.decagon.feedme.view.OnboardingActivity
import com.decagon.feedme.view.WelcomeActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.ui.AppBarConfiguration as AppBarConfiguration1

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    companion object {
        const val SHARED_PREF_CONFIG = "config"
        const val ONBOARDED = "onboarded"
        const val LOGGED_IN = "logged_in"
        const val USER_NAME = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavWithController()
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
//        appBarConfiguration = AppBarConfiguration1(
//            navGraph = navHostFragment.navController.graph,
//            drawerLayout = drawer_layout
//        )


//        val navController = findNavController(this, R.id.fragment_host)
//        findViewById<NavigationView>(R.id.nav_view)
//            .setupWithNavController(navController)

        val sharedPreferences = getSharedPreferences(SHARED_PREF_CONFIG, Context.MODE_PRIVATE)
        val onBoarded = sharedPreferences.getBoolean(ONBOARDED, false)
        val loggedIn = sharedPreferences.getBoolean(LOGGED_IN, false)
        if (!onBoarded) {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }
        if (!loggedIn) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun setupBottomNavWithController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)
    }
}
