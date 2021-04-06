package com.algo.phantoms.algo_phantoms.api

import com.algo.phantoms.algo_phantoms.AppConfig
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient
{
    private const val Base_Url = AppConfig.GITHUB_API_BASE_URL

    var gson = GsonBuilder()
        .setLenient()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl(Base_Url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val apiInstance = retrofit.create(Api::class.java)
}