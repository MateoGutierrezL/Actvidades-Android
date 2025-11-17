package com.example.shopapp.ui

sealed class Screen (val route: String) {

    data object Home: Screen(route = "homeScreen")
    data object ImageDescription: Screen(route = "imageDescription") {

        fun createRoute(imageId: Int, descriptionId: Int, price: Int): String {

            return "imageDescription/$imageId/$descriptionId/$price"
        }

        val routeWithArgs = "${route}/{imageId}/{descriptionId}/{price}"
    }

}