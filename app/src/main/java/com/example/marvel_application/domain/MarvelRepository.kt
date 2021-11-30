package com.example.marvel_application.domain

import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.network.Api
import com.example.marvel_application.model.remote.response.baseResponse.MarvelResponse
import com.example.marvel_application.model.remote.response.characters.Characters
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepository {

    fun getMarvelCharacters(): Flow<State<MarvelResponse<Characters>?>> =
        wrapWithFlow { Api.apiService.getMarvelCharacters() }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> = flow {
        emit(State.Loading)
        delay(1000)
        try {
            val result = function()
            if (result.isSuccessful) {
                emit(State.Success(result.body()))
            } else {
                emit(State.Error(result.message()))
            }
        } catch (e: Exception) {
            emit(State.Error(e.message.toString()))
        }
    }.catch{ e ->
       emit(State.Error("Response Error: ${e.message}"))
    }
}
