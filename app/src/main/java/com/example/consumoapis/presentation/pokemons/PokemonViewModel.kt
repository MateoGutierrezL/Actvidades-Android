package com.example.consumoapis.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumoapis.domain.useCase.GetPokemonCase
import com.example.consumoapis.presentation.pokemons.PokemonUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor (
    private val getPokemonCase: GetPokemonCase
): ViewModel(){

    private val _uiState = MutableStateFlow(value = PokemonUiState())

    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    init {
        loadPokemones()
    }

    fun loadPokemones(){

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                errorMessage = null
            )

            try {

                val pokemones = getPokemonCase()

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    pokemones = pokemones,
                    errorMessage = null
                )
            } catch (e: Exception){
                e.printStackTrace()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Ocurrio un error al cargar los pokemones"
                )


            }
        }
    }
}