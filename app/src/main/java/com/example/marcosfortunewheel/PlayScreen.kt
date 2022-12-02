package com.example.marcosfortunewheel.screens
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marcosfortunewheel.GameData.GameData.gameState
import com.example.marcosfortunewheel.GameData.GameData.guessed
import com.example.marcosfortunewheel.R
import com.example.marcosfortunewheel.Screen
import com.example.marcosfortunewheel.ViewModel

@SuppressLint("MutableCollectionMutableState","UnrememberedMutableState")
@Composable
fun GameScreen(navController: NavController){
    var viewModel = ViewModel()

    Column {
        var lives by remember {mutableStateOf(5)}
        var balance by remember {mutableStateOf(0) }
        var price by remember {mutableStateOf("")}
        var word by remember {mutableStateOf("")}
        var submit by remember {mutableStateOf(TextFieldValue(""))}
        var category by remember {mutableStateOf("")}
        var add by remember {mutableStateOf("")}
        val bankrupt by remember {mutableStateOf("OH NO! You lost it all")}
        val notBankrupt by remember {mutableStateOf("Possible prize: ")}
        var payed = 1
        var currentWord = ""
        var newgame = true

        Card(elevation = 10.dp){
            Image(contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(modifier = Modifier
                    .fillMaxSize()
                    .align(CenterHorizontally)
            ){
                Text(text = "Lives: $lives" ,fontWeight = FontWeight.Bold,
                    modifier=Modifier
                        .padding(8.dp)
                        .align(CenterHorizontally)
                )

                Text(text = "Balance: $balance",
                    fontWeight = FontWeight.Bold,
                    modifier=Modifier
                        .padding(1.dp)
                        .align(CenterHorizontally)
                )
                Image(painter = painterResource(id = R.drawable.finalwheel), contentDescription = null,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .size(360.dp)
                )
                Text(text = currentWord,
                    modifier = Modifier
                        .align(CenterHorizontally),
                    fontSize = 26.sp)

                Button(
                    onClick = {
                    if(newgame){
                        category = viewModel.getCategory()
                        word = viewModel.getWord(category)
                        currentWord = viewModel.hideWord(word)
                        newgame = false
                    }
                    if(gameState==false) {
                        gameState = true
                        add = viewModel.roll()

                        if (add == "0"){
                            price = bankrupt
                            balance = 0
                            gameState =false
                        }
                        else{
                            price = notBankrupt+add
                            gameState = true
                        }
                    }
                },
                    modifier = Modifier
                        .padding(vertical = 2.dp)
                        .align(CenterHorizontally)
                        .height(40.dp)
                        .width(160.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.Yellow)
                )
                {
                    Text(text = "Spin")
                }
                Text(price,
                    modifier = Modifier
                        .align(CenterHorizontally),
                    fontSize = 20.sp

                )

                Text("Guessed Letters: \n"+guessed.value.toString(),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(vertical = 2.dp),
                    fontSize = 20.sp

                )
                Text("Category:",
                    modifier = Modifier
                        .padding(2.dp)
                        .align(CenterHorizontally),

                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(category, modifier = Modifier
                        .align((CenterHorizontally)),
                    fontSize = 10.sp

                )
                TextField(value = submit,
                    onValueChange = {submit = it},
                    modifier = Modifier
                        .align(CenterHorizontally)
                )

                Button(onClick = {
                        if((submit.text.length == 1 && guessed.value.contains(submit.text.toCharArray()[0]) ||
                                    1 < submit.text.length && submit.text!=word) && gameState ==true
                        ) {
                            gameState = false
                            lives = lives - 1
                            if(lives < 1){
                                navController.navigate(Screen.GameOver.route)
                            }
                        }

                        if (gameState==true) {
                            if (submit.text.length == 1) {
                                viewModel.addGuess(submit.text.toCharArray()[0])
                                if(viewModel.validation(submit.text.toCharArray()[0],word)>0){
                                    balance+=add.toInt()* viewModel.validation(submit.text.toCharArray()[0],word)
                                    currentWord = viewModel.showWord(word,submit.text.toCharArray()[0],currentWord)
                                    payed = 1
                                    if(currentWord == word){
                                        navController.navigate(Screen.WinScreen.withArgs(balance.toString()))
                                    }
                                }
                                if (payed==0) {
                                    lives = lives - 1

                                    if(lives < 1){
                                        navController.navigate(Screen.GameOver.route)
                                    }

                                }
                            }
                            if (submit.text.length > 1) {
                                if (submit.text == word) {
                                    balance += add.toInt()*word.length
                                    navController.navigate(Screen.WinScreen.withArgs(balance.toString()))
                                    payed = 1
                                }
                            }
                            payed = 0
                        }
                        gameState = false
                    },
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.Yellow
                    ),
                ) {
                    Text(text = "Submit")
                }
            }

        }


    }

}





