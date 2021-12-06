package com.example.marvel_application.model.remote.response.comic


import com.google.gson.annotations.SerializedName

data class TextObject(
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("type")
    val type: String? = null
)