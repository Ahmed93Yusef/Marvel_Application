package com.example.marvel_application.model.remote.response.comic


import com.google.gson.annotations.SerializedName

data class ItemRole(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("role")
    val role: String? = null
)