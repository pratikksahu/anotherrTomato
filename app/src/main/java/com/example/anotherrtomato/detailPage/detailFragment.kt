package com.example.anotherrtomato.detailPage

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.anotherrtomato.R
import com.example.anotherrtomato.dataClass.dataClassRestaurants.Restaurant
import com.example.anotherrtomato.dataClass.dataClassRestaurants.restaurants
import com.example.anotherrtomato.sharedViewModel.SharedViewModel
import com.example.anotherrtomato.sharedViewModel.SharedViewModelFactory
import kotlinx.android.synthetic.main.detail_fragment.*

class detailFragment : Fragment() {

    companion object {
        fun newInstance() =
            detailFragment()
    }

    private lateinit var cuisine : String
    private lateinit var img : String

    private lateinit var viewModel: DetailViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModel.getRestaurantSelected().observe(viewLifecycleOwner , Observer {

            println("TESTING : ${it.restaurant.cuisines}")
            cuisineText.text = it.restaurant.cuisines
            Glide.with(this)
                .applyDefaultRequestOptions(RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground))
                .load(it.restaurant.featuredImage)
                .into(featuredImage)
        })
    }

}