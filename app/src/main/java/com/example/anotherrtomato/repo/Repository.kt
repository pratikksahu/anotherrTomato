package com.example.anotherrtomato.repo

import com.example.anotherrtomato.Database.DAO.RestaurantsDAO

class Repository(val restaurantsDAO: RestaurantsDAO){
    fun getRestaurantsList() = restaurantsDAO.getRestaurantsList()

    companion object{
        @Volatile private var instance : Repository? = null
        fun getInstance(restaurantsDAO: RestaurantsDAO){
            instance ?: synchronized(this){
                instance ?: Repository(restaurantsDAO).also { instance = it }
            }
        }
    }
}