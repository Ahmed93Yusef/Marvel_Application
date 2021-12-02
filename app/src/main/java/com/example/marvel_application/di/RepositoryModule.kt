package com.example.marvel_application.di

import android.content.Context
import androidx.navigation.Navigator
import com.example.marvel_application.domain.MarvelRepository
import com.example.marvel_application.domain.MarvelRepositoryImp
import com.example.marvel_application.domain.mapper.CharacterMapper
import com.example.marvel_application.domain.mapper.CharacterMapperById
import com.example.marvel_application.model.local.dao.MarvelCharactersDao
import com.example.marvel_application.model.local.dataBase.MarvelDatabase
import com.example.marvel_application.model.remote.network.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        apiService: MarvelService,
        mapper: CharacterMapper,
        mapperById: CharacterMapperById,
        charactersDao: MarvelCharactersDao
    ): MarvelRepository {
        return MarvelRepositoryImp(apiService, mapper,mapperById, charactersDao)
    }

    @Provides
    fun provideMapper(): CharacterMapper {
        return CharacterMapper()
    }

    @Provides
    fun provideMapperById(): CharacterMapperById {
        return CharacterMapperById()
    }

    @Provides
    fun provideMarvelCharactersDao(@ApplicationContext context: Context): MarvelCharactersDao{
        return MarvelDatabase.getInstance(context).marvelCharactersDao()
    }
}