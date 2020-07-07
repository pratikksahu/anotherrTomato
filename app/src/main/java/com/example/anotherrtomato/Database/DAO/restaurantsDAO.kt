package com.example.anotherrtomato.Database.DAO

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.anotherrtomato.`interface`.tomatoRestaurants
import com.example.anotherrtomato.dataClass.dataClassRestaurants.Restaurant
import com.example.anotherrtomato.dataClass.dataClassRestaurants.restaurants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class RestaurantsDAO{

    private val apiService = tomatoRestaurants()
    private val restaurants = MutableLiveData<restaurants>()
    private var restaurantList : restaurants? = null
    init {
        CoroutineScope(Main).launch {
             restaurantList = apiService?.getRestaurantsListAsync()?.await()
            if (restaurantList != null) {
                restaurants.value = restaurantList
            }
        }

    }

    fun getRestaurantsList() = restaurants as LiveData<restaurants>

}
