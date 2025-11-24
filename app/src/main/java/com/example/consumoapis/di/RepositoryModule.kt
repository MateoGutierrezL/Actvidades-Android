package com.example.consumoapis.di

import com.example.consumoapis.data.repository.PokemonRepositoryImpl
import com.example.consumoapis.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object RepositoryModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object RepositoryModule{

        @Provides
        @Singleton
        fun provideUserRepository(
            pokemonRepositoryimpl: PokemonRepositoryImpl
        ){

        }
    }
}