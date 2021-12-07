package com.example.marvel_application.model.remote.response.baseResponse


import com.google.gson.annotations.SerializedName

data class SubList<T>(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<T>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)