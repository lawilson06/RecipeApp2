package com.example.recipeapp2.details


import androidx.lifecycle.ViewModel
import com.example.recipeapp2.model.response.MealsDetailsListResponse

class MealDetailsViewModel () : ViewModel() {

    fun getDetails(successCallback: (response: MealsDetailsListResponse?) -> Unit, c: String)  {
        val repository: DetailsRepository = DetailsRepository(c=c)
        repository.getDetails() {response ->
            successCallback(response)
        }
    }
}