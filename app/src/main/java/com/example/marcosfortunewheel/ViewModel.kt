package com.example.marcosfortunewheel

import com.example.marcosfortunewheel.GameData.GameData.notGuessed
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    fun roll(): String {
        val prices = listOf( 0, 50, 100, 150, 200,400, 500, 1000, 2000, 5000)
        val price = prices[(Math.random() * 10).toInt()]
        return price.toString()
    }

    fun hideWord(word: String): String{
        var current = ""
        for(i in word.indices){
            current+='-'
        }
        return current
    }
        fun addGuess(guess: Char){
            notGuessed.value.add(guess)
        }
        fun getWord(category: String): String {
            var word = ""

            var words = listOf( GameData.GameData.country,
                                GameData.GameData.vegetables,
                                GameData.GameData.sports,
                                GameData.GameData.kitchen,
                                GameData.GameData.birds)
            for (i in words.indices) {
                if (words[i][0] == category) {
                    word = words[i].random()
                }
            }
            return word
        }
    fun validation(guess: Char,word: String): Int{
        var j = 0
        for (i in 0 until word.toCharArray().size) {
            if(guess == word.toCharArray()[i]){ j++ }
        }
        return j
    }

        fun getCategory(): String {
            var category = listOf<String>("country", "vegetables", "sports", "kitchen", "birds")
            return category[(Math.random() * category.size).toInt()]
        }



        fun showWord(word: String, guess: Char, current: String): String{
            var updatedWord = StringBuilder(current)
            for (i in word.indices) {
                if(guess == word.toCharArray()[i]){
                    updatedWord.setCharAt(i,guess)
                }
            }
            return updatedWord.toString()
        }

}
