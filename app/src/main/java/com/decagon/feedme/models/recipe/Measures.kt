package com.decagon.feedme.models.recipe


import com.google.gson.annotations.SerializedName

data class Measures(
    var metric: Metric,
    var us: Us
)