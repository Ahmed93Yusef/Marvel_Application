package com.example.marvel_application.model.remote.response.comic


import com.example.marvel_application.model.remote.response.baseResponse.Item
import com.example.marvel_application.model.remote.response.baseResponse.ItemType
import com.example.marvel_application.model.remote.response.baseResponse.SubList
import com.example.marvel_application.model.remote.response.baseResponse.Thumbnail
import com.example.marvel_application.model.remote.response.baseResponse.Url
import com.google.gson.annotations.SerializedName

data class ComicDto(
    @SerializedName("characters")
    val characters: SubList<Item>? = null,
    @SerializedName("collectedIssues")
    val collectedIssues: List<CollectedIssue>? = null,
    @SerializedName("collections")
    val collections: List<String>? = null,
    @SerializedName("creators")
    val creators: SubList<ItemRole>? = null,
    @SerializedName("dates")
    val dates: List<Date>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("diamondCode")
    val diamondCode: String? = null,
    @SerializedName("digitalId")
    val digitalId: Int? = null,
    @SerializedName("ean")
    val ean: String? = null,
    @SerializedName("events")
    val events: SubList<String>? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("images")
    val images: List<Image>? = null,
    @SerializedName("isbn")
    val isbn: String? = null,
    @SerializedName("issn")
    val issn: String? = null,
    @SerializedName("issueNumber")
    val issueNumber: Int? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("pageCount")
    val pageCount: Int? = null,
    @SerializedName("prices")
    val prices: List<Price>? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Item? = null,
    @SerializedName("stories")
    val stories: SubList<ItemType>? = null,
    @SerializedName("textObjects")
    val textObjects: List<TextObject>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("upc")
    val upc: String? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null,
    @SerializedName("variantDescription")
    val variantDescription: String? = null,
    @SerializedName("variants")
    val variants: List<Variant>? = null
)