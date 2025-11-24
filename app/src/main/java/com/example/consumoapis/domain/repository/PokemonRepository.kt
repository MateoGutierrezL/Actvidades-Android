package com.example.consumoapis.domain.repository

import com.example.consumoapis.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemon(): List<Pokemon>

}