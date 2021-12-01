package com.example.marvel_application.domain

import android.util.Log
import com.example.marvel_application.domain.mapper.CharacterMapper
import com.example.marvel_application.model.local.dataBase.MarvelDatabase
import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.network.MarvelService
import com.example.marvel_application.util.Constant.TAG
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val apiService: MarvelService,
) : MarvelRepository {

    private val charactersDao = MarvelDatabase.getInstance.marvelCharactersDao()
    private val mapper = CharacterMapper()

    override fun getMarvelCharacters(): Flow<List<CharactersEntity>?> =
        charactersDao.getCatchCharacters()

    override suspend fun refreshCharacters() {
        try {
            val response = apiService.getMarvelCharacters()
            val items = response.body()?.dataCharacters?.characters?.map { mapper.map(it) }
            items?.let { charactersDao.addCharacters(it) }
        } catch (e: Exception){
            Log.i(TAG, "refreshCharacters: ${e.message}")
        }
    }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> = flow {
        emit(State.Loading)
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
    }.catch { e ->
        emit(State.Error("Response Error: ${e.message}"))
    }
}