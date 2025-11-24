package com.example.consumoapis.presentation.pokemons

import com.example.consumoapis.domain.model.Pokemon

data class PokemonUiState (
    val isLoading: Boolean = false,
    val pokemones: List<Pokemon> = emptyList(),
    val errorMessage: String? = null
)