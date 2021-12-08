package com.example.marvel_application.di

import com.example.marvel_application.domain.repository.MarvelRepository
import com.example.marvel_application.domain.repository.MarvelRepositoryImp
import com.example.marvel_application.domain.mapper.MarvelMapper
import com.example.marvel_application.model.local.dao.MarvelDao
import com.example.marvel_application.model.remote.network.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        apiService: MarvelService,
        mapper: MarvelMapper,
        charactersDao: MarvelDao
    ): MarvelRepository {
        return MarvelRepositoryImp(apiService, mapper, charactersDao)
    }

    @Provides
    fun provideMarvelMapper(): MarvelMapper{
        return Mappers.getMapper(MarvelMapper::class.java)
    }
}