package com.example.marvel_application.model.remote.response.comic


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("type")
    val type: String? = null
)