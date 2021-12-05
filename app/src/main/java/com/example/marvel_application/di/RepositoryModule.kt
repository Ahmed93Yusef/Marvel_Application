package com.example.marvel_application.di

import android.content.Context
import com.example.marvel_application.domain.MarvelRepository
import com.example.marvel_application.domain.MarvelRepositoryImp
import com.example.marvel_application.domain.mapper.MarvelMapper
import com.example.marvel_application.model.local.dao.MarvelCharactersDao
import com.example.marvel_application.model.local.dataBase.MarvelDatabase
import com.example.marvel_application.model.remote.network.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        apiService: MarvelService,
        mapper: MarvelMapper,
        charactersDao: MarvelCharactersDao
    ): MarvelRepository {
        return MarvelRepositoryImp(apiService, mapper, charactersDao)
    }

    @Provides
    fun provideMarvelCharactersDao(@ApplicationContext context: Context): MarvelCharactersDao{
        return MarvelDatabase.getInstance(context).marvelCharactersDao()
    }

    @Provides
    fun provideMarvelMapper(): MarvelMapper{
        return Mappers.getMapper(MarvelMapper::class.java)
    }
}