package com.example.shopapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.shopapp.ui.ImageDescription
import com.example.shopapp.ui.HomeScreen
import com.example.shopapp.ui.Screen

@Composable
fun AppNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.ImageDescription.routeWithArgs, // Ruta que fue especificada para el AppNavGraph
            arguments = listOf(

                navArgument("imageId") { type = NavType.IntType },
                navArgument("descriptionId") { type = NavType.IntType },
                navArgument("price") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val imageId = backStackEntry.arguments?.getInt("imageId") ?: -1
            val descriptionId = backStackEntry.arguments?.getInt("descriptionId") ?: -1
            val price = backStackEntry.arguments?.getInt("price") ?: -1

            // Llama al Composable de destino con los datos extraídos
            ImageDescription(
                imageSourceId = imageId, descriptionId = descriptionId, price = price,
                onBack = {
                    navController.popBackStack()
                })
        }
    }
}