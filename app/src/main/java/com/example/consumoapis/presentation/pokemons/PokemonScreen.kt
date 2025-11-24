package com.example.consumoapis.presentation.pokemons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.consumoapis.domain.model.Pokemon
import com.example.consumoapis.presentation.user.PokemonViewModel

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    // Observa el StateFlow<UserUiState> como estado de Compose
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // --- 1) Loading ---
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // --- 2) Error ---
        // Muestra el mensaje de error si existe (y si no estamos cargando, aunque la lógica del ViewModel debería evitar esto)
        else if (uiState.errorMessage != null) {
            Text(
                text = uiState.errorMessage!!, // Usamos !! porque ya comprobamos que no es null
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // --- 3) Contenido (Lista de usuarios) ---
        // Muestra la lista solo si no está cargando y no hay error
        else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.pokemones) { pokemon ->
                    PokemonItem(pokemon = pokemon)
                }
            }
        }
    }
}

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = pokemon.url,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}