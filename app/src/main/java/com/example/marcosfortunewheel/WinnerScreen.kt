package com.example.marcosfortunewheel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun WinScreen(navController: NavController,balance: String){
    Column (verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Card(elevation = 10.dp) {
            Image(contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(modifier = Modifier
                    .fillMaxSize()
                    .align(CenterHorizontally)
            ) {
                Text(text = "YOU WON",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .align(CenterHorizontally)
                )
                Text(text = "Score: $balance",
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .align(CenterHorizontally)
                )
                Image(contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.champion_golden_trophy_cup_with_red_winner_ribbon_on_transparent_background_png),
                    contentDescription = null,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .size(350.dp)
                )

                Button(onClick = { navController.navigate(Screen.GameScreen.route) },
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

