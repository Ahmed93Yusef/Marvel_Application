package com.example.marvel_application.model.local.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvel_application.model.local.dao.MarvelDao
import com.example.marvel_application.model.local.entity.*

@Database(entities = [
    CharactersEntity::class,
    ComicEntity::class,
    CreatorsEntity::class,
    EventEntity::class,
    SeriesEntity::class,
    SearchEntity::class
], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class MarvelDatabase : RoomDatabase() {

    abstract fun marvelCharactersDao(): MarvelDao
}