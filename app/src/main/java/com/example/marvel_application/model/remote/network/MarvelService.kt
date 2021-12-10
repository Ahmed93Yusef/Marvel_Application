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
import retrofit2.http.Query

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun getMarvelCharacters(): Response<MarvelResponse<CharactersDto>?>

    @GET("/v1/public/characters?")
    suspend fun getMarvelCharactersSearch(@Query("nameStartsWith") name: String): Response<MarvelResponse<CharactersDto>?>

    @GET("/v1/public/comics?")
    suspend fun getMarvelComics(@Query("nameStartsWith") name: String? = null): Response<MarvelResponse<ComicDto>?>

    @GET("/v1/public/creators?")
    suspend fun getMarvelCreators(@Query("nameStartsWith") name: String? = null): Response<MarvelResponse<CreatorsDto>?>

    @GET("/v1/public/events?")
    suspend fun getMarvelEvents(@Query("nameStartsWith") name: String? = null): Response<MarvelResponse<EventDto>?>

    @GET("/v1/public/series?")
    suspend fun getMarvelSeries(@Query("nameStartsWith") name: String? = null): Response<MarvelResponse<SeriesDto>?>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getMarvelCharactersById(@Path("characterId") characterId: Long):
            Response<MarvelResponse<CharactersDto>?>

    @GET("/v1/public/comics/{comicId}")
    suspend fun getMarvelComicsById(@Path("comicId") comicId: Long):
            Response<MarvelResponse<ComicDto>?>

    @GET("/v1/public/creators/{creatorsId}")
    suspend fun getMarvelCreatorsById(@Path("creatorsId") creatorsId: Long):
            Response<MarvelResponse<CreatorsDto>?>

    @GET("/v1/public/events/{eventsId}")
    suspend fun getMarvelEventsById(@Path("eventsId") eventsId: Long):
            Response<MarvelResponse<EventDto>?>

    @GET("/v1/public/series/{seriesId}")
    suspend fun getMarvelSeriesById(@Path("seriesId") seriesId: Long):
            Response<MarvelResponse<SeriesDto>?>
}
