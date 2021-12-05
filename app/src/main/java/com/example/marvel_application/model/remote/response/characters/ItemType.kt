package com.example.marvel_application.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class ItemType(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("type")
    val type: String? = null
)