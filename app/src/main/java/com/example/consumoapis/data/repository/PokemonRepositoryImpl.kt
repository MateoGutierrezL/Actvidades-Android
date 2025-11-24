package com.example.consumoapis.data.repository

import com.example.consumoapis.data.PokemonApi
import com.example.consumoapis.data.remote.dto.toDomain
import com.example.consumoapis.domain.model.Pokemon
import com.example.consumoapis.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemon(): List<Pokemon>{
        val response = pokemonApi.getPokemon()

        return response.results.map { it.toDomain() }
    }
}