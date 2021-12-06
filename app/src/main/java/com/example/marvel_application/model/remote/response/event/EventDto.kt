package com.example.marvel_application.model.remote.response.event


import com.example.marvel_application.model.remote.response.baseResponse.*
import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("characters")
    val characters: SubList<Item>? = null,
    @SerializedName("comics")
    val comics: SubList<Item>? = null,
    @SerializedName("creators")
    val creators: SubList<ItemType>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("end")
    val end: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("next")
    val next: Item? = null,
    @SerializedName("previous")
    val previous: Item? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: SubList<Item>? = null,
    @SerializedName("start")
    val start: String? = null,
    @SerializedName("stories")
    val stories: SubList<ItemType>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)