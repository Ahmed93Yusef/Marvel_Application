package com.example.marvel_application.model.remote.network

import com.example.marvel_application.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private fun getClient(): Retrofit {
        val clientInterceptor = OkHttpClient.Builder()
            .addInterceptor(MyInter).build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientInterceptor)
            .build()
    }
    val apiService: ApiService = getClient().create(ApiService::class.java)
}
