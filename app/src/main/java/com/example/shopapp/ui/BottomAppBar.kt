package com.example.shopapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shopapp.R

@Composable
fun BottomAppBar(){

    BottomAppBar(

        modifier = Modifier.fillMaxWidth()
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){

            IconButton(onClick = {}) {

                Icon(
                    painter = painterResource(R.drawable.libro),
                    contentDescription = "Libro",
                    modifier = Modifier.size(24.dp)

                )
            }

            IconButton(onClick = {}) {

                Icon(
                    painterResource(R.drawable.busqueda),
                    contentDescription = "Busqueda",
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = {}) {

                Icon(
                    painterResource(R.drawable.corazon),
                    contentDescription = "Corazon",
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = {}) {

                Icon(
                    painterResource(R.drawable.perfil),
                    contentDescription = "Perfil",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}