package com.example.anotherrtomato.homePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anotherrtomato.repo.Repository

@Suppress("UNCHECKED_CAST")
class homeViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return homeViewModel(repository) as T
    }
}