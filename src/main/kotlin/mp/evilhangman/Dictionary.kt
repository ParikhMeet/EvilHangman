package mp.evilhangman

import java.io.File

class Dictionary {

    private val words: List<String> = File(javaClass.classLoader.getResource("dictionary.txt").file).readLines()

    private fun getWordMap(): Map<Int, List<String>> = words.groupBy({ it.length }, { it })

    var guessCount = 0
    var guessedChars = mutableSetOf<Char>()
    val actualWordLength = getWordMap().keys.random()
    var eligibleWords = getWordMap()[actualWordLength]
    val actualWord = eligibleWords!!.random()

    fun guess(c: Char) {

        fun generateWordFamilies(): List<List<String>> {
            return listOf()
        }

        fun selectWordFamily(): List<String> {
            return listOf()
        }

        if (c in guessedChars) {
            println("Character already guessed earlier.")
        } else {
            //Increment guessCount
            guessCount++

            //Add to guessed chars
            guessedChars.add(c)

            //generate word families

            //select a word family

            //modify eligible words accordingly

            //winner if actualWord is the guessedWord
        }
    }

}

