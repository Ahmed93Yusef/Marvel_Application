package com.example.marvel_application.model.remote.response.baseResponse


import com.google.gson.annotations.SerializedName

data class DataMarvel<T>(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("results")
    val marvelData: List<T>? = null,
    @SerializedName("total")
    val total: Int? = null
)