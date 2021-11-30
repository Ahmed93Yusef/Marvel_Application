package com.example.marvel_application.model.remote.response.baseResponse


import com.google.gson.annotations.SerializedName

data class DataMarvel<T>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("results")
    val characters: List<T>?,
    @SerializedName("total")
    val total: Int?
)