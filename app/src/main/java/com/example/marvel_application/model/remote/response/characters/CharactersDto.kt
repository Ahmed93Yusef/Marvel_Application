package com.example.marvel_application.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("comics")
    val comics: SubList<Item>?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("events")
    val events: SubList<Item>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList<Item>?,
    @SerializedName("stories")
    val stories: SubList<ItemType>?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("urls")
    val urls: List<Url>?
)