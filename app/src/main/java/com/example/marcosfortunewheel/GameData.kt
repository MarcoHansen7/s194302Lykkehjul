package com.example.marcosfortunewheel
import androidx.compose.runtime.*
import android.annotation.SuppressLint

class GameData {

    object GameData{
        var gameState = false
        @SuppressLint("MutableCollectionMutableState")
        val notGuessed: MutableState<MutableList<Char>> = mutableStateOf(mutableListOf(' '))
        var guessed: State<List<Char>> = notGuessed

        val birds= listOf<String>("birds","goose", "duck", "eagle", "parrot", "pidgeon","dove")
        val vegetables = listOf<String>("vegetables","broccoli", "cucumber", "carrot", "potato", "radish")
        val sports = listOf<String>("sports","football","mma", "karate","handball", "swimming", "basketball", "golf", "dancing")
        val country = listOf<String>("country","denmark", "sweden", "brazil","qatar","switzerland","mexico")
        val kitchen = listOf<String>("kitchen","apron", "knife", "oven", "fridge", "pan","sink")

    }


}