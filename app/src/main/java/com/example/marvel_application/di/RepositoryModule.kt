package com.example.marvel_application.di

import com.example.marvel_application.domain.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(): MarvelRepository {
        return MarvelRepository()
    }
}