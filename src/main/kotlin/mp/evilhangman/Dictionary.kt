package mp.evilhangman

import java.io.File

class Dictionary {

    private val words: List<String> = File(javaClass.classLoader.getResource("dictionary.txt").file).readLines()

    private fun getWordMap(): Map<Int, List<String>> = words.groupBy({ it.length }, { it })

    var guessCount = 0
    var guessedChars = mutableListOf<Char>()
    val actualWordLength = getWordMap().keys.random()
    var eligibleWords = getWordMap()[actualWordLength]
    val actualWord = eligibleWords!!.random()

}

