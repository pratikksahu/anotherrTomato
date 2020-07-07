package com.example.anotherrtomato.homePage


import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.anotherrtomato.R
import com.example.anotherrtomato.dataClass.dataClassRestaurants.Restaurant
import com.example.anotherrtomato.sharedViewModel.SharedViewModel
import kotlinx.android.synthetic.main.restaurant_list_item.view.*

class RecyclerViewAdapter constructor(private var list : List<Restaurant> , private var sharedViewModel: SharedViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return itemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_list_item , parent , false)
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is itemViewHolder ->{
                holder.bind(list[position])
            }
        }
        holder.itemView.setOnClickListener {
            sharedViewModel.setRestaurant(list[position])
            it.findNavController().navigate(R.id.action_blankFragment_to_detailFragment)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class itemViewHolder constructor(
        itemView : View
    ) : RecyclerView.ViewHolder(itemView){

        private val name = itemView.restaurantName
        private val rating = itemView.rating
        private val starRating = itemView.starRating
        private val card = itemView.informationCard


        fun bind(restaurant: Restaurant){
           name.text = restaurant.restaurant.name
            name.typeface = Typeface.DEFAULT_BOLD
            rating.text = restaurant.restaurant.userRating.ratingText
            rating.typeface = Typeface.DEFAULT_BOLD
            starRating.text = restaurant.restaurant.userRating.ratingObj.title.text
            starRating.typeface = Typeface.DEFAULT_BOLD
            val temp = "#${restaurant.restaurant.userRating.ratingColor}"
            card.setCardBackgroundColor(Color.parseColor(temp))
        }
    }
}