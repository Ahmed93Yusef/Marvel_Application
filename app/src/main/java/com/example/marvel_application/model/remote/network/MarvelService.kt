package com.example.marvel_application.model.remote.network

import com.example.marvel_application.model.remote.response.baseResponse.MarvelResponse
import com.example.marvel_application.model.remote.response.characters.CharactersDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    @GET("/v1/public/characters")
    suspend fun getMarvelCharacters(): Response<MarvelResponse<CharactersDto>?>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getMarvelCharactersById(@Path("characterId") characterId: Long):
            Response<MarvelResponse<CharactersDto>?>
}
