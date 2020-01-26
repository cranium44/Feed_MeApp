package com.decagon.feedme.controllers

import android.util.Log
import com.decagon.feedme.models.User
import com.google.firebase.auth.FirebaseAuth
import kotlin.properties.Delegates

object UserRepository {
    private var isSuccessful = false
    private var isCreated by Delegates.notNull<Boolean>()
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
        isCreated = false
        if (!(email.isEmpty() || password.isEmpty())){
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    isCreated = it.isSuccessful
                }
        }

        return isCreated
    }



}