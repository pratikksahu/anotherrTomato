package com.example.anotherrtomato.dataClass.dataClassRestaurants


import com.example.anotherrtomato.dataClass.dataClassRestaurants.Restaurant
import com.google.gson.annotations.SerializedName

data class restaurants(
    @SerializedName("restaurants")
    val restaurants: List<Restaurant>,
    @SerializedName("results_found")
    val resultsFound: Int
)