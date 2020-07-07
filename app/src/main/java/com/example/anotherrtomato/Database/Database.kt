package com.example.anotherrtomato.Database

import com.example.anotherrtomato.Database.DAO.RestaurantsDAO

class Database private constructor(){
    var restaurantsDAO = RestaurantsDAO()
        private set

    companion object{
        @Volatile private var instance:Database? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: Database().also { instance = it }
            }
    }
}