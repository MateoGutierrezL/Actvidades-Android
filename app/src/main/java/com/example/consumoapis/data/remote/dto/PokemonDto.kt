package com.example.consumoapis.data.remote.dto

import com.example.consumoapis.domain.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class PokemonDto(
    val name: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class PokemonListResponseDto(
    @Json(name = "results")
    val results: List<PokemonDto>
)

fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        name = name,
        url = url
    )
}

