package com.decagon.feedme.models.recipe


import com.google.gson.annotations.SerializedName

data class Metric(
    var amount: Int,
    var unitLong: String,
    var unitShort: String
)