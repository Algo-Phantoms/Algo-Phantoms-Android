package com.algo.phantoms.algo_phantoms.api

import com.algo.phantoms.algo_phantoms.AppConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Api {

    companion object{
        operator fun invoke():Api {
            return Retrofit.Builder()
                .baseUrl(AppConfig.GITHUB_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(RetrofitClient.gson))
                .build()
                .create(Api::class.java)
        }
    }
}