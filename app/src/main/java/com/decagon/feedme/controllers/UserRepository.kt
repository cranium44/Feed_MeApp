package com.decagon.feedme.controllers

import com.google.firebase.auth.FirebaseAuth

object UserRepository {
    private var isSuccessful = false
    private val firebaseAuth = FirebaseAuth.getInstance()
    private fun checkLogin(email: String, password: String): Boolean{
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                isSuccessful = it.isSuccessful
            }

        return isSuccessful
    }
}