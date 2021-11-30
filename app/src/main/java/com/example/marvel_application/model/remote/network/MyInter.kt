package com.example.marvel_application.model.remote.network

import android.util.Log
import com.example.marvel_application.util.Constant
import com.example.marvel_application.util.Constant.TAG
import okhttp3.Interceptor
import okhttp3.Response

object MyInter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestHttpUrl = request.url.newBuilder()
            .addQueryParameter(Constant.TIMESTAMP_PARAM, "1")
            .addQueryParameter(Constant.API_KEY_PARAM, "2be3a614b2e9365513e61c296a6220a6")
            .addQueryParameter(Constant.HASH_PARAM, "5ad3649758508b6e305e786425dbb05d")
            .build()
        val req = request.newBuilder().url(requestHttpUrl).build()
        Log.i(TAG, "interceptMyInter222: ${req.body.toString()}")
        return chain.proceed(req)
    }

}