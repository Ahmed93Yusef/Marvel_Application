package com.example.marvel_application.model.remote.network

import com.example.marvel_application.model.remote.response.baseResponse.MarvelResponse
import com.example.marvel_application.model.remote.response.characters.CharactersDto
import com.example.marvel_application.model.remote.response.comic.ComicDto
import com.example.marvel_application.model.remote.response.creators.CreatorsDto
import com.example.marvel_application.model.remote.response.event.EventDto
import com.example.marvel_application.model.remote.response.series.SeriesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun getMarvelCharacters(): Response<MarvelResponse<CharactersDto>?>

    @GET("/v1/public/comics")
    suspend fun getMarvelComics(): Response<MarvelResponse<ComicDto>?>

    @GET("/v1/public/creators")
    suspend fun getMarvelCreators(): Response<MarvelResponse<CreatorsDto>?>

    @GET("/v1/public/events")
    suspend fun getMarvelEvents(): Response<MarvelResponse<EventDto>?>

    @GET("/v1/public/series")
    suspend fun getMarvelSeries(): Response<MarvelResponse<SeriesDto>?>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getMarvelCharactersById(@Path("characterId") characterId: Long):
            Response<MarvelResponse<CharactersDto>?>
}
