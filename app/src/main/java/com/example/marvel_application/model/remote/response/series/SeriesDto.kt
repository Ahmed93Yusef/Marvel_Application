package com.example.marvel_application.model.remote.response.series


import com.example.marvel_application.model.remote.response.baseResponse.*
import com.google.gson.annotations.SerializedName

data class SeriesDto(
    @SerializedName("characters")
    val characters: SubList<Item>? = null,
    @SerializedName("comics")
    val comics: SubList<Item>? = null,
    @SerializedName("creators")
    val creators: SubList<ItemType>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("endYear")
    val endYear: Int? = null,
    @SerializedName("events")
    val events: SubList<String>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("startYear")
    val startYear: Int? = null,
    @SerializedName("stories")
    val stories: SubList<ItemType>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)