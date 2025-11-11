package com.example.claseactividad.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


//Esta data class se encarga de manejar los datos que lleva cada una de las imgenes, en este
//caso se maneja unicamente la imagen y una descripción, ambos elementos son traidos de la carpeta
//R en donde las imagenes estan en drawable y las descripciones en values/strings
data class Imagen (

    @DrawableRes val imageSourceId: Int,
    @StringRes val description: Int

)



