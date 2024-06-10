package com.example.recipeapp2.model

import android.util.Log
import com.example.recipeapp2.model.api.MealsWebService
import com.example.recipeapp2.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository (private val webService: MealsWebService = MealsWebService(), val c : String){
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit)  {
        return webService.getMeals(c).enqueue(object: Callback<MealsCategoriesResponse>{
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
                Log.d(
                    "TAG_MEALS_REPOSITORY_SUCCESS",
                    "Callback succeeded in retrieving a response."
                )
            }

            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                Log.d(
                    "TAG_MEALS_REPOSITORY_FAILURE",
                    "Callback failed to retrieve a response.")
            }
        })
    }
}
