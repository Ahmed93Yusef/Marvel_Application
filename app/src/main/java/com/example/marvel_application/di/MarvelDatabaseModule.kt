package com.example.marvel_application.di

import android.content.Context
import androidx.room.Room
import com.example.marvel_application.model.local.dao.MarvelDao
import com.example.marvel_application.model.local.dataBase.MarvelDatabase
import com.example.marvel_application.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarvelDatabaseModule {

    @Singleton
    @Provides
    fun provideBuildDatabase(@ApplicationContext context: Context) : MarvelDatabase {
        return Room.databaseBuilder(
            context,
            MarvelDatabase::class.java,
            Constant.DB_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideMarvelCharactersDao(marvelDatabase: MarvelDatabase): MarvelDao {
        return marvelDatabase.marvelCharactersDao()
    }
}