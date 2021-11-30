package com.example.marvel_application.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class ItemType(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("type")
    val type: String?
)