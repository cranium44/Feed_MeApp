package com.decagon.feedme.models.recipe


import com.google.gson.annotations.SerializedName

data class Step(
    var equipment: List<Any>,
    var ingredients: List<Any>,
    var length: Length,
    var number: Int,
    var step: String
)