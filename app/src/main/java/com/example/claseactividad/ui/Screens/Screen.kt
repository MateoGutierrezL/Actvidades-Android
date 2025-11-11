package com.example.claseactividad.ui.Screens

//Sealed class que tiene cada una de las rutas en la app como lo es Home y ImageDescription
sealed class Screen (val route: String) {

    data object Home: Screen(route = "homeScreen")
    data object ImageDescription: Screen(route = "imageDescription") {

        // Esta pantalla se creara a partir de una ruta la ccual necesita un id de una imagen y un id de la descripcion
        fun createRoute(imageId: Int, descriptionId: Int): String {

            return "imageDescription/$imageId/$descriptionId"
        }

        // Aquí se define el patrón de la ruta para ser usado en el AppNavGraph
        val routeWithArgs = "${route}/{imageId}/{descriptionId}"
    }

}