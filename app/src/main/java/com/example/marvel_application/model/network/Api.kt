package com.example.marvel_application.model.network

import com.example.marvel_application.util.Constant
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
            .addInterceptor(MyInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientInterceptor)
            .build()
    }
    val apiService: ApiService = getClient().create(ApiService::class.java)
}
