package com.example.marvel_application.domain

import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.network.MarvelService
import com.example.marvel_application.model.remote.response.baseResponse.MarvelResponse
import com.example.marvel_application.model.remote.response.characters.Characters
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

interface MarvelRepository {
    fun getMarvelCharacters(): Flow<State<MarvelResponse<Characters>?>>
}