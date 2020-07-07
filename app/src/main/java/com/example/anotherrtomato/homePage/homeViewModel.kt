package com.example.anotherrtomato.homePage

import androidx.lifecycle.ViewModel
import com.example.anotherrtomato.repo.Repository

class homeViewModel(private val repository: Repository) : ViewModel() {
    fun getRestaurantsList() = repository.getRestaurantsList()
}