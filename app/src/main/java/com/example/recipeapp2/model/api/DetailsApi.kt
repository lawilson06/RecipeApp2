package com.example.recipeapp2.model.api

import com.example.recipeapp2.model.response.MealsDetailsListResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class DetailsWebService() {
    private lateinit var api: DetailsApi
    init {
        val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").addConverterFactory(
            GsonConverterFactory.create())
            .build()

        api = retrofit.create(DetailsApi::class.java)
    }

    fun getDetails(c : String) : Call<MealsDetailsListResponse> {
        return api.getDetails(c)
    }

    interface DetailsApi {

        @GET("lookup.php")
        fun getDetails(@Query("i") meals: String) : Call<MealsDetailsListResponse>

    }
}

