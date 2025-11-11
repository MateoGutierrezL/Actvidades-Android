package com.example.claseactividad.data

import com.example.claseactividad.model.Imagen
import com.example.claseactividad.R

//Esta clase se encarga de crear una lista apartir de muchos objetos de la clase Imagen que se encuentra dentro de model
//Aqui se entregan los datos para las imagenes con su respectiva descripción.
class DataSource {

    val Imagenes = listOf(
        Imagen(imageSourceId = R.drawable.pixel_art_1, description = R.string.descripcion_imagen_1),
        Imagen(imageSourceId = R.drawable.pixel_art_2, description = R.string.descripcion_imagen_2),
        Imagen(imageSourceId = R.drawable.pixel_art_3, description = R.string.descripcion_imagen_3),
        Imagen(imageSourceId = R.drawable.pixel_art_4, description = R.string.descripcion_imagen_4),
        Imagen(imageSourceId = R.drawable.pixel_art_5, description = R.string.descripcion_imagen_5),
        Imagen(imageSourceId = R.drawable.pixel_art_6, description = R.string.descripcion_imagen_6),
        Imagen(imageSourceId = R.drawable.pixel_art_7, description = R.string.descripcion_imagen_7),
        )

}