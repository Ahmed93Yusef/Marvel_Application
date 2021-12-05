package com.example.marvel_application.model.local.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvel_application.model.local.dao.MarvelCharactersDao
import com.example.marvel_application.model.local.entity.CharactersEntity

@Database(entities = [CharactersEntity::class], version = 1, exportSchema = false)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun marvelCharactersDao(): MarvelCharactersDao

    companion object {
        private const val DB_NAME = "MarvelCatchDatabase"

        fun getInstance(context: Context) : MarvelDatabase {
            return  synchronized(this) { buildDatabase(context) }
        }

        private fun buildDatabase(context: Context) : MarvelDatabase {
            return Room.databaseBuilder(context, MarvelDatabase::class.java, DB_NAME).build()
        }
    }
}