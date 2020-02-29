package com.decagon.feedme.models

import java.time.Duration

data class Post(
    var name: String,
    var recipeName: String,
    var recipe_difficulty: String,
    var likes: Long,
    var duration: String
)