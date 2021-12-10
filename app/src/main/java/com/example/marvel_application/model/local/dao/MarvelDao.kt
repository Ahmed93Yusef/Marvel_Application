package com.example.marvel_application.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_application.model.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComic(items: List<ComicEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCreators(items: List<CreatorsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(items: List<EventEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSeries(items: List<SeriesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addResentSearch(items: List<SearchEntity>)

    @Query("Select * from CHARACTERS_TABLE")
    fun getCatchCharacters(): Flow<List<CharactersEntity>>

    @Query("Select * from COMIC_TABLE")
    fun getCatchComic(): Flow<List<ComicEntity>>

    @Query("Select * from CREATORS_TABLE")
    fun getCatchCreators(): Flow<List<CreatorsEntity>>

    @Query("Select * from EVENT_TABLE")
    fun getCatchEvent(): Flow<List<EventEntity>>

    @Query("Select * from SERIES_TABLE")
    fun getCatchSeries(): Flow<List<SeriesEntity>>

    @Query("Select * from SEARCH_TABLE ORDER BY date DESC")
    fun getCatchResentSearch(): Flow<List<SearchEntity>>
}