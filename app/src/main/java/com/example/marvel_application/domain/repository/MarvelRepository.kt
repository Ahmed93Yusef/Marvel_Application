package com.example.marvel_application.domain.repository

import com.example.marvel_application.domain.models.*
import com.example.marvel_application.model.local.entity.ComicEntity
import com.example.marvel_application.model.remote.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getMarvelCharacters(): Flow<List<Characters>>

    fun getMarvelComic(): Flow<List<Comic>>

    fun getMarvelCreators(): Flow<List<Creators>>

    fun getMarvelEvent(): Flow<List<Event>>

    fun getMarvelSeries(): Flow<List<Series>>

    fun getMarvelCharactersById(characterId: Long): Flow<State<Characters>?>

    suspend fun refreshCharacters()
    suspend fun refreshComic()
    suspend fun refreshCreators()
    suspend fun refreshEvent()
    suspend fun refreshSeries()
}