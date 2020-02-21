package com.decagon.feedme.models.recipe


import com.google.gson.annotations.SerializedName

data class AnalyzedInstruction(
    var name: String,
    var steps: List<Step>
)