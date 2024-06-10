package com.example.recipeapp2.details

import android.util.Log
import com.example.recipeapp2.model.api.DetailsWebService

import com.example.recipeapp2.model.response.MealsDetailsListResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsRepository (private val webService: DetailsWebService = DetailsWebService(), val c : String){
        fun getDetails(successCallback: (response: MealsDetailsListResponse?) -> Unit)  {
            return webService.getDetails(c).enqueue(object: Callback<MealsDetailsListResponse> {
                override fun onResponse(
                    call: Call<MealsDetailsListResponse>,
                    response: Response<MealsDetailsListResponse>
                ) {
                    if(response.isSuccessful)
                        successCallback(response.body())
                    Log.d(
                        "TAG_DETAILS_REPOSITORY_SUCCESS",
                        "Callback succeeded in retrieving a response."
                    )
                }

                override fun onFailure(call: Call<MealsDetailsListResponse>, t: Throwable) {
                    Log.d(
                        "TAG_DETAILS_REPOSITORY_FAILURE",
                        "Callback failed in retrieving a response."
                    )
                }
            })
        }
    }

