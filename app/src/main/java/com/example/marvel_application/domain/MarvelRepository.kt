package com.example.marvel_application.domain

import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.model.remote.State
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getMarvelCharacters(): Flow<List<CharactersEntity>?>

    fun getMarvelCharactersById(characterId: Long): Flow<State<Characters>?>

    suspend fun refreshCharacters()
}