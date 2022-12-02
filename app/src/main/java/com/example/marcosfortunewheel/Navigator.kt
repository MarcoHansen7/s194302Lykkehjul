package com.example.marcosfortunewheel
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.compose.composable
import com.example.marcosfortunewheel.screens.GameScreen
import com.example.marcosfortunewheel.screens.LoseScreen
//this was taken from a youtube video, link in readme

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.GameScreen.route){

        composable(
            route = Screen.GameScreen.route){
            GameScreen(navController = navController)
        }
        composable(
            route = Screen.WinScreen.route+"/{balance}",
        arguments = listOf(navArgument("balance"){
            type = NavType.StringType
            defaultValue = ""
        }
        )
        ) {entry ->
            entry.arguments?.getString("balance")
                ?.let { WinScreen(balance = it,navController = navController) }
        }
        composable(route = Screen.GameOver.route){
            LoseScreen(navController = navController)
        }

        }
    }


