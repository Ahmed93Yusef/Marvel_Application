package com.example.marvel_application.model.network

import com.example.marvel_application.util.Constant.API_TOKEN
import com.example.marvel_application.util.Constant.AUTH_NAME_HEADER
import okhttp3.*

object MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val mRequest = chain.request()
            .newBuilder()
            .header(AUTH_NAME_HEADER, API_TOKEN)
            .build()
        return chain.proceed(mRequest)
    }
}
