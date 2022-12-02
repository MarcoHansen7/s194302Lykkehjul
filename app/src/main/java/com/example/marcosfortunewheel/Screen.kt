package com.example.marcosfortunewheel

sealed class Screen(val route : String){

    object GameScreen : Screen("playscreen")
    object GameOver : Screen("gameoverscreen")
    object WinScreen : Screen("winnerscreen")

    fun withArgs(vararg args : String): String{

        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
