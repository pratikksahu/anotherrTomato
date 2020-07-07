package com.example.anotherrtomato.dataClass.dataClassRestaurants


import com.google.gson.annotations.SerializedName

data class RestaurantX(
    @SerializedName("cuisines")
    val cuisines: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("user_rating")
    val userRating: UserRating,
    @SerializedName("featured_image")
    val featuredImage: String
)