package com.example.test_8.domain.model

import com.squareup.moshi.Json

data class Item (
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    val reactionCount: Int,
    val rate: Int?
)