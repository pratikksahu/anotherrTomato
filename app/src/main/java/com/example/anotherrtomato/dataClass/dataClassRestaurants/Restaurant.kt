package com.example.anotherrtomato.dataClass.dataClassRestaurants


import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("restaurant")
    val restaurant: RestaurantX
)