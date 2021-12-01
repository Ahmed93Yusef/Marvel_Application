package com.example.marvel_application.model.remote.network

import android.util.Log
import com.example.marvel_application.BuildConfig
import com.example.marvel_application.util.Constant
import com.example.marvel_application.util.Constant.TAG
import com.example.marvel_application.util.md5
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val timestamp = System.currentTimeMillis().toString()
        val apiKey = BuildConfig.PUBLIC_API_KEY
        val hash = "$timestamp${BuildConfig.PRIVATE_API_KEY}$apiKey".md5()

        with(chain.request()){
            url.newBuilder().apply {
                addQueryParameter(Constant.TIMESTAMP_PARAM, timestamp)
                addQueryParameter(Constant.API_KEY_PARAM, apiKey)
                addQueryParameter(Constant.HASH_PARAM, hash)
            }.build().also {
                val mResponse = this.newBuilder().url(it).build()
                Log.i(TAG, "intercept: ${mResponse.body}")
                return chain.proceed(mResponse)
            }
        }
    }
}
