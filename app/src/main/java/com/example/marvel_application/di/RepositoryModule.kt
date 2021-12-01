package com.example.marvel_application.di

import com.example.marvel_application.domain.MarvelRepository
import com.example.marvel_application.domain.MarvelRepositoryImp
import com.example.marvel_application.domain.mapper.CharacterMapper
import com.example.marvel_application.model.local.dao.MarvelCharactersDao
import com.example.marvel_application.model.local.dataBase.MarvelDatabase
import com.example.marvel_application.model.remote.network.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        apiService: MarvelService,
        mapper: CharacterMapper,
        charactersDao: MarvelCharactersDao
    ): MarvelRepository {
        return MarvelRepositoryImp(apiService, mapper, charactersDao)
    }

    @Provides
    fun provideMapper(): CharacterMapper {
        return CharacterMapper()
    }

    @Provides
    fun provideMarvelCharactersDao(): MarvelCharactersDao{
        return MarvelDatabase.getInstance.marvelCharactersDao()
    }
}