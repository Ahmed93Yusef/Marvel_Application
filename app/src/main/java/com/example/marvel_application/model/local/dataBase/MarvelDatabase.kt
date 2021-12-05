package com.example.marvel_application.model.local.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvel_application.model.local.dao.MarvelCharactersDao
import com.example.marvel_application.model.local.entity.CharactersEntity

@Database(entities = [CharactersEntity::class], version = 1, exportSchema = false)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun marvelCharactersDao(): MarvelCharactersDao
}