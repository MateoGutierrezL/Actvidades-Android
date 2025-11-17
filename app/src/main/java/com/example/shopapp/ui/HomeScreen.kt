package com.example.shopapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shopapp.ui.Screen
import com.example.shopapp.data.DataSource
import com.example.shopapp.model.Product

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar()
        },

        bottomBar = {

            BottomAppBar()
        }
    ) { paddingValues ->

        ProductList(
            productList = DataSource.DataSource.products,
             modifier = Modifier.padding(paddingValues),
            navController = navController
        )
    }
}

@Composable
fun ProductList(
    productList: List<Product>,
    modifier: Modifier = Modifier,
    navController: NavController
){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(horizontal = 8.dp)
    ){
        items(items = productList){ product ->

            ProductItem(
                product = product,
                onItemClick = {

                    val route = Screen.ImageDescription.createRoute(
                        imageId = it.imageResourceId,
                        descriptionId = it.descriptionId,
                        price = it.price
                    )
                    navController.navigate(route)
                }
            )
        }
    }

}