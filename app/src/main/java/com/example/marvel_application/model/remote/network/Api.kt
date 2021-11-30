package com.example.marvel_application.model.remote.network

import com.example.marvel_application.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {
    private fun getClient(): Retrofit {
        val clientInterceptor = OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor).build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientInterceptor)
            .build()

    }
    val apiService: ApiService = getClient().create(ApiService::class.java)
}
