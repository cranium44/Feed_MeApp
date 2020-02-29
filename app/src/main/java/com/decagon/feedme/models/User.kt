package com.decagon.feedme.models

data class User(
    var id: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var password: String,
    var dateOfBirth: String,
    var address: String,
    var vegetarian: Boolean = false
)