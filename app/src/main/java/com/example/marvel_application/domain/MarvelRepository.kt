package com.example.marvel_application.domain

import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.response.baseResponse.MarvelResponse
import com.example.marvel_application.model.remote.response.characters.CharactersDto
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getMarvelCharacters(): Flow<List<CharactersEntity>?>

    suspend fun refreshCharacters()
}