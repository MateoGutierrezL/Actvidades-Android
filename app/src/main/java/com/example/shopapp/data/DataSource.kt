package com.example.shopapp.data

import com.example.shopapp.model.Product
import com.example.shopapp.R

class DataSource {

    object DataSource{

        val products = listOf(
            Product(R.drawable.cotton_shirt, R.string.descripcion_imagen_1, 24),
            Product(R.drawable.negro_slim_fit_shirt, R.string.descripcion_imagen_2, 40),
            Product(R.drawable.polo_shirt, R.string.descripcion_imagen_3, 30),
            Product(R.drawable.red_dress, R.string.descripcion_imagen_4, 60),
            Product(R.drawable.black_dress, R.string.descripcion_imagen_5, 90),
            Product(R.drawable.white_dress, R.string.descripcion_imagen_6, 100)

        )
    }

}