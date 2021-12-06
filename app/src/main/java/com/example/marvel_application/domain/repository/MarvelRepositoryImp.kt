package com.example.marvel_application.domain.repository

import android.util.Log
import com.example.marvel_application.domain.mapper.MarvelMapper
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.model.local.dao.MarvelCharactersDao
import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.network.MarvelService
import com.example.marvel_application.util.Constant.TAG
import kotlinx.coroutines.flow.*
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val apiService: MarvelService,
    private val mapper: MarvelMapper,
    private val charactersDao: MarvelCharactersDao
) : MarvelRepository {

    override fun getMarvelCharacters(): Flow<List<Characters>> =
         charactersDao.getCatchCharacters().map { characterEntity ->
             characterEntity.map {
                 mapper.convertCharacterEntityToDomain(it)
             }
         }

    override fun getMarvelCharactersById(characterId: Long): Flow<State<Characters>?> = flow {
        emit(State.Loading)
        try {
            Log.i(TAG, "MarvelRepositoryImp............: $characterId")
            val response = apiService.getMarvelCharactersById(characterId)
            if (response.isSuccessful){
                val items = response.body()?.marvelResponse?.marvelData?.map { mapper.convertCharacterDtoToDomain(it) }?.get(0)
                emit(State.Success(items))
            }else{
                emit(State.Error(response.message()))
            }
        }catch (e: Throwable){
            Log.i(TAG, "refreshCharacters: ${e.message}")
        }
    }


    override suspend fun refreshCharacters() {
        try {
            val response = apiService.getMarvelCharacters()
            val items = response.body()?.marvelResponse?.marvelData?.map { mapper.convertCharacterDtoToEntity(it) }
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