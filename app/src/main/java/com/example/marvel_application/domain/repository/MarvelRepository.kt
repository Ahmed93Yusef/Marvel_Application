package com.example.marvel_application.domain.repository

import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.domain.models.Comic
import com.example.marvel_application.domain.models.Event
import com.example.marvel_application.model.remote.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getMarvelCharacters(): Flow<List<Characters>>

    fun getMarvelComic(): Flow<List<Comic>>

    fun getMarvelEvent(): Flow<List<Event>>

    fun getMarvelCharactersById(characterId: Long): Flow<State<Characters>?>

    suspend fun refreshItems()
}