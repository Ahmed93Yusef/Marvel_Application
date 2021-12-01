package com.example.marvel_application.model.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_application.model.local.entity.CharactersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Query("Select * from CHARACTERS_TABLE")
    fun getCatchCharacters(): Flow<List<CharactersEntity>>
}