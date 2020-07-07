package com.example.anotherrtomato.homePage

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anotherrtomato.R
import com.example.anotherrtomato.databinding.RestaurantListItemBinding
import com.example.anotherrtomato.sharedViewModel.SharedViewModel
import com.example.anotherrtomato.sharedViewModel.SharedViewModelFactory
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class home : Fragment() {

    companion object {
        fun newInstance() = home()
    }

    private lateinit var viewModel: homeViewModel
    private lateinit var sharedViewModel: SharedViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = Injector().provideHomeViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(homeViewModel::class.java)

        //To communicate between detailFragment and homeFragment
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        viewModel.getRestaurantsList().observe(requireActivity() , Observer {
            MainScope().launch{
                println("TESTING")
                recyclerRestaurantList.apply {
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(Spacing(10))
                    adapter = RecyclerViewAdapter(it.restaurants , sharedViewModel)
                }
            }
        })
    }


}