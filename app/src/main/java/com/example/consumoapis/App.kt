package com.example.consumoapis

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.consumoapis.presentation.pokemons.PokemonScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text( text = "Lista de pokemones")}
            )
        }
    ){ innerPadding ->

        PokemonScreen(
            modifier = Modifier.padding(innerPadding)
        )

    }
}