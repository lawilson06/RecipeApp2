package com.example.recipeapp2.model.api

import com.example.recipeapp2.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MealsWebService() {
    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        api = retrofit.create(MealsApi::class.java)
    }


    fun getMeals(c: String): Call<MealsCategoriesResponse> {
        return api.getMeals(c)
    }

    interface MealsApi {

        @GET("filter.php")
        fun getMeals(@Query("a") meals: String): Call<MealsCategoriesResponse>


    }
}

