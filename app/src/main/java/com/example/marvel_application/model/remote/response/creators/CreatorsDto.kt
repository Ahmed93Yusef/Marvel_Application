package com.example.marvel_application.model.remote.response.creators


import com.example.marvel_application.model.remote.response.baseResponse.*
import com.google.gson.annotations.SerializedName

data class CreatorsDto(
    @SerializedName("comics")
    val comics: SubList<Item>? = null,
    @SerializedName("events")
    val events: SubList<Item>? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("fullName")
    val fullName: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("middleName")
    val middleName: String? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: SubList<Item>? = null,
    @SerializedName("stories")
    val stories: SubList<ItemType>? = null,
    @SerializedName("suffix")
    val suffix: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)