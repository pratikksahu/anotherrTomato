package com.example.anotherrtomato.sharedViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anotherrtomato.dataClass.dataClassRestaurants.Restaurant

class SharedViewModel() : ViewModel(){
    private var restaurantSelected = MutableLiveData<Restaurant>()
    private var restaur : Restaurant? = null

    fun setRestaurant(restaurant: Restaurant){
        restaur = restaurant
        restaurantSelected.value = restaur
    }
    fun getRestaurantSelected() = restaurantSelected as LiveData<Restaurant>
}