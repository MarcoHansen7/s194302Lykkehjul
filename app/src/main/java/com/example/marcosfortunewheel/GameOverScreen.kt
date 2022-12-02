package com.example.marcosfortunewheel.screens
import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marcosfortunewheel.R
import com.example.marcosfortunewheel.Screen


@Composable
fun LoseScreen(navController: NavController) {
    Column (verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Card(elevation = 10.dp) {
            Image(contentScale = ContentScale.FillBounds,
                painter = painterResource(
                    id = R.drawable.background
                ),
                contentDescription = null,

                modifier = Modifier
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(CenterHorizontally)

            ) {
                Text(
                    text = "GAME OVER",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .align(CenterHorizontally)
                )
                Image(contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.gameover),
                    contentDescription = null,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .size(250.dp)
                )

                Button(onClick = {
                    navController.navigate(Screen.GameScreen.route)
                },
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(20.dp)
                ) {
                    Text(text = "Play again")
                }

            }
        }
    }


}
