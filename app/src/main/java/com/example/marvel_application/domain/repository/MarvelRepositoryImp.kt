package com.example.marvel_application.domain.repository

import android.util.Log
import com.example.marvel_application.domain.mapper.MarvelMapper
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.domain.models.Comic
import com.example.marvel_application.domain.models.Event
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

    override fun getMarvelComic(): Flow<List<Comic>> =
        charactersDao.getCatchComic().map { comicEntity ->
            comicEntity.map {
                mapper.convertComicEntityToDomain(it)
            }
        }


    override fun getMarvelEvent(): Flow<List<Event>> =
        charactersDao.getCatchEvent().map { eventEntity ->
            eventEntity.map {
                mapper.convertEventEntityToDomain(it)
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


    override suspend fun refreshItems() {
        try {
            val responseCharacter = apiService.getMarvelCharacters()
            val itemsCharacter = responseCharacter.body()?.marvelResponse?.marvelData?.map { mapper.convertCharacterDtoToEntity(it) }
            itemsCharacter?.let { charactersDao.addCharacters(it) }

            val responseComic = apiService.getMarvelComics()
            val itemsComic = responseComic.body()?.marvelResponse?.marvelData?.map { mapper.convertComicDtoToEntity(it) }
            itemsComic?.let { charactersDao.addComic(it) }

            val responseEvent = apiService.getMarvelEvents()
            val itemsEvent = responseEvent.body()?.marvelResponse?.marvelData?.map { mapper.convertEventDtoToEntity(it) }
            itemsEvent?.let { charactersDao.addEvent(it) }
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