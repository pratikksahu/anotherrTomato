package com.example.anotherrtomato.homePage

import com.example.anotherrtomato.Database.Database
import com.example.anotherrtomato.repo.Repository

class Injector{
    fun provideHomeViewModelFactory() : homeViewModelFactory {
    val repository = Repository(Database.getInstance().restaurantsDAO)
        return homeViewModelFactory(repository)
    }
}