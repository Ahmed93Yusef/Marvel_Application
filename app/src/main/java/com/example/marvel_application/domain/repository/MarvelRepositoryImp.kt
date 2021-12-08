package com.example.marvel_application.domain.repository

import android.util.Log
import com.example.marvel_application.domain.mapper.MarvelMapper
import com.example.marvel_application.domain.models.*
import com.example.marvel_application.model.local.dao.MarvelDao
import com.example.marvel_application.model.local.entity.ComicEntity
import com.example.marvel_application.model.remote.State
import com.example.marvel_application.model.remote.network.MarvelService
import com.example.marvel_application.util.Constant.TAG
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val apiService: MarvelService,
    private val mapper: MarvelMapper,
    private val marvelDao: MarvelDao,
) : MarvelRepository {

    override fun getMarvelCharacters(): Flow<List<Characters>> =
        marvelDao.getCatchCharacters().map { characterEntity ->
            characterEntity.map {
                mapper.convertCharacterEntityToDomain(it)
            }
        }

    override fun getMarvelComic(): Flow<List<Comic>> =
        marvelDao.getCatchComic().map { comicEntity ->
            comicEntity.map {
                mapper.convertComicEntityToDomain(it)
            }
        }

    override fun getMarvelCreators(): Flow<List<Creators>> =
        marvelDao.getCatchCreators().map { creatorsEntity ->
            creatorsEntity.map {
                mapper.convertCreatorsEntityToDomain(it)
            }
        }

    override fun getMarvelEvent(): Flow<List<Event>> =
        marvelDao.getCatchEvent().map { eventEntity ->
            eventEntity.map {
                mapper.convertEventEntityToDomain(it)
            }
        }

    override fun getMarvelSeries(): Flow<List<Series>> =
        marvelDao.getCatchSeries().map { seriesEntity ->
            seriesEntity.map {
                mapper.convertSeriesEntityToDomain(it)
            }
        }

    override fun getMarvelCharactersById(characterId: Long): Flow<State<Characters>?> = flow {
        emit(State.Loading)
        try {
            Log.i(TAG, "MarvelRepositoryImp............: $characterId")
            val response = apiService.getMarvelCharactersById(characterId)
            if (response.isSuccessful) {
                val items = response.body()?.marvelResponse?.marvelData?.map {
                    mapper.convertCharacterDtoToDomain(it)
                }?.get(0)
                emit(State.Success(items))
            } else {
                emit(State.Error(response.message()))
            }
        } catch (e: Throwable) {
            Log.i(TAG, "refreshCharacters: ${e.message}")
        }
    }


    override suspend fun refreshCharacters() {
        try {
            val responseCharacters = apiService.getMarvelCharacters()
            val itemsCharacters = responseCharacters.body()?.marvelResponse?.marvelData?.map {
                mapper.convertCharacterDtoToEntity(it)
            }
            itemsCharacters?.let { marvelDao.addCharacters(it) }
        } catch (e: Exception) {
            Log.i(TAG, "refreshCharacters: ${e.message}")
        }
    }

    override suspend fun refreshComic() {
        try {
            val responseComic = apiService.getMarvelComics()
            val itemsComic = responseComic.body()?.marvelResponse?.marvelData?.map {
                mapper.convertComicDtoToEntity(it)
            }
            itemsComic?.let { marvelDao.addComic(it) }
        } catch (e: Exception) {
            Log.i(TAG, "refreshComic: ${e.message}")
        }
    }

    override suspend fun refreshCreators() {
        try {
            val responseCreators = apiService.getMarvelCreators()
            val itemsCreators = responseCreators.body()?.marvelResponse?.marvelData?.map {
                mapper.convertCreatorsDtoToEntity(it)
            }
            itemsCreators?.let { marvelDao.addCreators(it) }
        } catch (e: Exception) {
            Log.i(TAG, "refreshCreators: ${e.message}")
        }
    }

    override suspend fun refreshEvent() {
        try {
            val responseEvent = apiService.getMarvelEvents()
            val itemsEvent = responseEvent.body()?.marvelResponse?.marvelData?.map {
                mapper.convertEventDtoToEntity(it)
            }
            itemsEvent?.let { marvelDao.addEvent(it) }
        } catch (e: Exception) {
            Log.i(TAG, "refreshEvent: ${e.message}")
        }
    }

    override suspend fun refreshSeries() {
        try {
            val responseSeries = apiService.getMarvelSeries()
            val itemsSeries = responseSeries.body()?.marvelResponse?.marvelData?.map {
                mapper.convertSeriesDtoToEntity(it)
            }
            itemsSeries?.let { marvelDao.addSeries(it) }
        } catch (e: Exception) {
            Log.i(TAG, "refreshSeries: ${e.message}")
        }
    }

//    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> = flow {
//        emit(State.Loading)
//        try {
//            val result = function()
//            if (result.isSuccessful) {
//                emit(State.Success(result.body()))
//            } else {
//                emit(State.Error(result.message()))
//            }
//        } catch (e: Exception) {
//            emit(State.Error(e.message.toString()))
//        }
//    }.catch { e ->
//        emit(State.Error("Response Error: ${e.message}"))
//    }
}