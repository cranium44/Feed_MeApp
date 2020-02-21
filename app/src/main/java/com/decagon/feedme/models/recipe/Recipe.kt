package com.decagon.feedme.models.recipe


import com.google.gson.annotations.SerializedName

data class Recipe(
    var aggregateLikes: Int,
    var analyzedInstructions: List<AnalyzedInstruction>,
    var cheap: Boolean,
    var creditsText: String,
    var cuisines: List<Any>,
    var dairyFree: Boolean,
    var diets: List<String>,
    var dishTypes: List<String>,
    var extendedIngredients: List<ExtendedIngredient>,
    var gaps: String,
    var glutenFree: Boolean,
    var healthScore: Int,
    var id: Int,
    var image: String,
    var imageType: String,
    var instructions: String,
    var license: String,
    var lowFodmap: Boolean,
    var occasions: List<String>,
    var pricePerServing: Double,
    var readyInMinutes: Int,
    var servings: Int,
    var sourceName: String,
    var sourceUrl: String,
    var spoonacularScore: Int,
    var spoonacularSourceUrl: String,
    var sustainable: Boolean,
    var title: String,
    var vegan: Boolean,
    var vegetarian: Boolean,
    var veryHealthy: Boolean,
    var veryPopular: Boolean,
    var weightWatcherSmartPoints: Int,
    var winePairing: WinePairing
)