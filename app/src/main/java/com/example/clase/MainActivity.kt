package com.example.clase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clase.ui.theme.ClaseTheme
import com.example.clase.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Home(){

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column (
            modifier = Modifier.fillMaxSize().border(border = BorderStroke(color = Purple40, width = 2.dp)),
            verticalArrangement = Arrangement.SpaceEvenly
        ){

            Row (modifier = Modifier.fillMaxWidth().height(40.dp).border(border = BorderStroke(color = Purple40, width = 2.dp))){  }

            Row (modifier = Modifier.fillMaxWidth().height(40.dp).border(border = BorderStroke(color = Purple40, width = 2.dp)),
                horizontalArrangement = Arrangement.SpaceEvenly){

                Column (){
                    Text("1")
                    Text("2")
                }

                Column {
                    Text("3")
                    Text("4")
                }

                Column {
                    Text("5")
                    Text("6")
                }
            }

            Row (modifier = Modifier.fillMaxWidth().height(40.dp).border(border = BorderStroke(color = Purple40, width = 2.dp))){  }
        }
    }
}

