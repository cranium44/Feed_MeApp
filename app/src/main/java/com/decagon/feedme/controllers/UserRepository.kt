package com.decagon.feedme.controllers

import com.decagon.feedme.models.User
import com.google.firebase.auth.FirebaseAuth

object UserRepository {
    private var isSuccessful = false
    private var isCreated = false
    private val firebaseAuth = FirebaseAuth.getInstance()


    fun checkLogin(email: String, password: String): Boolean{
        if(email.isEmpty() || password.isEmpty()){
            isSuccessful = false
        }else{
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    isSuccessful = it.isSuccessful
                }
        }
        return isSuccessful
    }

    fun createUser(email: String, password: String): Boolean{

        if (!(email.isEmpty() || password.isEmpty())){
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    isCreated = it.isSuccessful
                }
        }

        return isCreated
    }



}