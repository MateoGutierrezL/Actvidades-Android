package com.example.consumoapis.data

import com.example.consumoapis.data.remote.dto.PokemonListResponseDto
import retrofit2.http.GET

interface PokemonApi {

    @GET(value = "pokemon")
    suspend fun getPokemon(): PokemonListResponseDto
}