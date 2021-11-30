package com.example.marvel_application.model.remote.network

import com.example.marvel_application.model.remote.response.baseResponse.MarvelResponse
import com.example.marvel_application.model.remote.response.characters.Characters
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/characters")
    suspend fun getMarvelCharacters(): Response<MarvelResponse<Characters>?>
}
