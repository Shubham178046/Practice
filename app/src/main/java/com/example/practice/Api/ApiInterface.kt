package com.example.practice.Api

import com.example.practice.Model.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {
    @GET("api")
    fun getData(@Header("x-rapidapi-key") xrapidapikey : String) : Call<BaseResponse>
}