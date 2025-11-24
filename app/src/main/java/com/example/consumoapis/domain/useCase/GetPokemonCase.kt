package com.example.consumoapis.domain.useCase

import com.example.consumoapis.domain.model.Pokemon
import com.example.consumoapis.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(): List<Pokemon>{
        return pokemonRepository.getPokemon()
    }
}