package com.example.marvel_application.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("comics")
    val comics: SubList<Item>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("events")
    val events: SubList<Item>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: SubList<Item>? = null,
    @SerializedName("stories")
    val stories: SubList<ItemType>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)