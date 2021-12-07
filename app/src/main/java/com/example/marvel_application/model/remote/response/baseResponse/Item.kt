package com.example.marvel_application.model.remote.response.baseResponse


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)