package com.decagon.feedme.models.recipe


import com.google.gson.annotations.SerializedName

data class ExtendedIngredient(
    var aisle: String,
    var amount: Int,
    var consitency: String,
    var id: Int,
    var image: String,
    var measures: Measures,
    var meta: List<String>,
    var metaInformation: List<String>,
    var name: String,
    var original: String,
    var originalName: String,
    var originalString: String,
    var unit: String
)