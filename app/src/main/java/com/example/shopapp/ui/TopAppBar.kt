package com.example.shopapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shopapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){

    TopAppBar(

        title = {
            //Boton Flecha
            IconButton(
                onClick = {}
            ) { Icon(
                painter = painterResource(R.drawable.flecha),
                contentDescription = "owo",
                modifier = Modifier
                    .size(20.dp)
            ) }

            Text(
                "Shirts",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 11.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    )

}