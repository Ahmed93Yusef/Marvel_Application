package com.example.marvel_application.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class SubList<T>(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<T>?,
    @SerializedName("returned")
    val returned: Int?
)