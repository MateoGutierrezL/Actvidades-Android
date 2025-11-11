package com.example.claseactividad.ui.Screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.claseactividad.R
import com.example.claseactividad.ui.theme.ClaseActividadTheme


//Esta clase es la pantalla que se muestra despues de presionar las imagenes del carrusel
//Aqui recibimos como parametros el id de la imagen y el id de la descripcion, ademas se maneja la posibilidad de contemplar nulls

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageDescription(
    @DrawableRes imageSourceId: Int,
    @StringRes descriptionId: Int
) {

    //Variable para manejar la nullabilidad de la descripcion
    val descriptionText = if (descriptionId != -1) {
        stringResource(id = descriptionId)
    } else {
        "Descripción no encontrada"
    }

    //Agregamos los estilos de la pp y añadimos un topbar
    ClaseActividadTheme {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.imagen)) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Manejo de la posible nullabilidad de la imagen
                if (imageSourceId != -1) {
                    Image(
                        painter = painterResource(id = imageSourceId),
                        contentDescription = descriptionText,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(text = "Error: Imagen no válida")
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = descriptionText,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}