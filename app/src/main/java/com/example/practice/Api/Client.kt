package com.example.practice.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class Client {
    companion object {
        val okHttpClient  = OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(240, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()


        fun getService() :ApiInterface
        {
            var retrofit = Retrofit.Builder().baseUrl(AppConstant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
                okHttpClient).build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}