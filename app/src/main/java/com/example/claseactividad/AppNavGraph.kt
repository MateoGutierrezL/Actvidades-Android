package com.example.claseactividad

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.claseactividad.ui.Screens.HomeScreen
import com.example.claseactividad.ui.Screens.ImageDescription
import com.example.claseactividad.ui.Screens.Screen

//Clase para manejar las rutas de las diferentes pantallas, esta es la clase principal y la de mas alto nivel
//Unicamente hay dos posibles pantallas por lo que solo hay dos rutas
@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        //Manejo de la ruta de homeScreen, trayendo el elemento de la sealed class
        composable (route = Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable (
            route = Screen.ImageDescription.routeWithArgs, // Ruta que fue especificada para el AppNavGraph
            arguments = listOf(

                //El NavType se encarga de  validar que los datos que se esten pasando como argumento realmente sean int
                //En caso de entregar otro tipo de dato la navegacion va a fallar
                navArgument("imageId") { type = NavType.IntType },
                navArgument("descriptionId") { type = NavType.IntType }
            )
        ){ backStackEntry ->
            // 'backStackEntry' contiene los datos de la navegación.
            // Usamos el operador Elvis (?:) para asignar -1 si el argumento no se encuentra,
            // lo cual previene un NullPointerException y maneja errores de forma segura.
            //Las llaves que se necesitan para el getInt proviene del navArgument que esta arriba
            val imageId = backStackEntry.arguments?.getInt("imageId") ?: -1
            val descriptionId = backStackEntry.arguments?.getInt("descriptionId") ?: -1

            // Llama al Composable de destino con los datos extraídos
            ImageDescription(imageSourceId = imageId, descriptionId = descriptionId,
                onBack = {
                navController.popBackStack()
            })
        }
    }
}