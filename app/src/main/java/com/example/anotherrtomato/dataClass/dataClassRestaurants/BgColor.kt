package com.example.anotherrtomato.dataClass.dataClassRestaurants


import com.google.gson.annotations.SerializedName

data class BgColor(
    @SerializedName("tint")
    val tint: String,
    @SerializedName("type")
    val type: String
)