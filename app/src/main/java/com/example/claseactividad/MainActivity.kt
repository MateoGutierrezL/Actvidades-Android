package com.example.claseactividad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.claseactividad.ui.Screens.HomeScreen
import com.example.claseactividad.ui.theme.ClaseActividadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaseActividadTheme {

                //Instancia del navController para poder usar el AppNavGraph ya que esta tenia ese parametro
                //Usamos el remember para que pueda recordar la instancia del navController
                val navController = rememberNavController()

                AppNavGraph(navController = navController)
            }
        }
    }
}
