package com.example.claseactividad.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.claseactividad.R
import com.example.claseactividad.data.DataSource
import com.example.claseactividad.model.Imagen
import com.example.claseactividad.ui.theme.ClaseActividadTheme

//Esta es la pantalla Home y el punto de entrada a la App, Aqui se usa un topbar, y se utiliza el comopsable
//de CarruselItems para cada una de las imagenes aplicadas dentro del LazyRow
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val dataSource = DataSource()
    val imagenes = dataSource.Imagenes

    //Manejo de material para diseños de la app
    ClaseActividadTheme {

        Scaffold (
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(stringResource(id = R.string.carrusel_imagenes))},
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        ){ paddingValues ->

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(paddingValues = paddingValues).fillMaxSize()) {

                //LazyRow para el desplazamiento horizontal en la app de cada una de las imagenes
                LazyRow {
                    items(imagenes) { imagen ->
                        CarruselItem(
                            imagen = imagen,
                            onItemClick = {
                                // Usamos la función createRoute para generar la URL final y navegar a esa pestaña de ImageDescription
                                //La convenccion de it permite que se acceda a ese unico objeto del cual necesitamos la informacion
                                val route = Screen.ImageDescription.createRoute(
                                    imageId = it.imageSourceId,
                                    descriptionId = it.description
                                )
                                navController.navigate(route)
                            }
                        )
                    }
                }
            }
        }
    }
}

//Este composable forma cada item que se necesita para el carrusel de las imagenes, en este caso unicamente es necesario
//El uso de las imagenes por lo que no vamos a usar descripciones
@Composable
fun CarruselItem(
    imagen: Imagen,
    modifier: Modifier = Modifier,
    onItemClick: (Imagen) -> Unit
){
    Image(
        painter = painterResource(id = imagen.imageSourceId),
        contentDescription = stringResource(imagen.description),
        //ContentScale.Crop se encarga de ajustar la imagen al tamaño designado
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(400.dp)
            .padding(horizontal = 10.dp)
            .clickable {

                //Para poder crear la pantalla de la descripcion de imagenes necesitamos la instancia de la clase Imagen
                //Ya que cuando vayamos a usar eesto en el composable superior necesitaremos acceder a la imagen y descripcion de cada elemento
                onItemClick(imagen)
            }
    )

}

