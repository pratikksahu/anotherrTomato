package com.example.anotherrtomato.dataClass.dataClassRestaurants


import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("text")
    val text: String
)