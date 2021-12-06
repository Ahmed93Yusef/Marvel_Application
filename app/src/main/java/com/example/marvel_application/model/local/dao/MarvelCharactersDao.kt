package com.example.marvel_application.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.model.local.entity.ComicEntity
import com.example.marvel_application.model.local.entity.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComic(items: List<ComicEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(items: List<EventEntity>)

    @Query("Select * from CHARACTERS_TABLE")
    fun getCatchCharacters(): Flow<List<CharactersEntity>>

    @Query("Select * from COMIC_TABLE")
    fun getCatchComic(): Flow<List<ComicEntity>>

    @Query("Select * from EVENT_TABLE")
    fun getCatchEvent(): Flow<List<EventEntity>>
}