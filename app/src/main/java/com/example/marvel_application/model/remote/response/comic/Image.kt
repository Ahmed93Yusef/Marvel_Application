package com.example.marvel_application.model.remote.response.comic


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("extension")
    val extension: String? = null,
    @SerializedName("path")
    val path: String? = null
)