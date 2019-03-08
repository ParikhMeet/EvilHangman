package mp.evilhangman

class EvilHangman {

    var guessCount = 0
    var guessedChars = mutableSetOf<Char>()
    val actualWordLength = Dictionary.wordMap.keys.random()
    var eligibleWords = Dictionary.wordMap[actualWordLength]
    val actualWord = eligibleWords!!.random()

    init {
        println("Generating new Hangman Game")
        println("Actual word length: $actualWordLength")
        println("Actual word: $actualWord")
        println("Eligible words: $eligibleWords")
    }

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