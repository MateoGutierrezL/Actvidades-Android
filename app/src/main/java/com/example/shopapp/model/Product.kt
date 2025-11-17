package com.example.shopapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product (
    @DrawableRes val imageResourceId: Int,
    @StringRes val descriptionId: Int,
    val price: Int
)