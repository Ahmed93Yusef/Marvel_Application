package com.example.marvel_application.model.remote.response.baseResponse


import com.google.gson.annotations.SerializedName

data class MarvelResponse<T>(
    @SerializedName("attributionHTML")
    val attributionHTML: String? = null,
    @SerializedName("attributionText")
    val attributionText: String? = null,
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("data")
    val marvelResponse: DataMarvel<T>? = null,
    @SerializedName("etag")
    val tag: String? = null,
    @SerializedName("status")
    val status: String? = null
)