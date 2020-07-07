package com.example.anotherrtomato.`interface`


import com.example.anotherrtomato.dataClass.dataClassRestaurants.restaurants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory.Companion as CoroutineCallAdapterFactory1

const val API_KEY = "6a725074e7a6692b2b7c88ba7445c7be"

//curl -X GET --header "Accept: application/json" --header "user-key: 6a725074e7a6692b2b7c88ba7445c7be"
// "https://developers.zomato.com/api/v2.1/search?lat=21.19385&lon=81.350941"
interface tomatoRestaurants {

    //Result is limited to 20
    @GET("search?lat=21.19385&lon=81.350941")
    fun getRestaurantsListAsync(): Deferred<restaurants>

    fun getRestaurantMenu()

    companion object {
        operator fun invoke(): tomatoRestaurants? {
            val interceptor = Interceptor { chain ->
                var request = chain.request()
                request = request?.newBuilder()
                    ?.addHeader("user-key", API_KEY)
                    ?.addHeader("Accept", "application/json")
                    ?.build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://developers.zomato.com/api/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory1())
                .build()
                .create(tomatoRestaurants::class.java)
        }

    }
}