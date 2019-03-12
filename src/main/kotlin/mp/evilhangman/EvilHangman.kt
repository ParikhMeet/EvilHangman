package mp.evilhangman

data class Family(var position: Set<Int>, var words: List<String>)
data class Status(
    val count: Int = 0,
    val guessedChars: Set<Char> = mutableSetOf(),
    val currentWordAppearance: String,
    val winner: Boolean = false
)

class EvilHangman {

    var guessCount = 0
    var guessedChars = mutableSetOf<Char>()
    val actualWordLength = Dictionary.wordMap.keys.random()
    var eligibleWords = Dictionary.wordMap[actualWordLength]
    val maskedChar = '_'

    init {
        println("Generating new Hangman Game")
        println("Actual word length: $actualWordLength")
        println("Eligible words: $eligibleWords")
    }

    private fun mask(): String {
        return eligibleWords!![0].map {
            if (guessedChars.contains(it)) {
                it
            } else {
                maskedChar
            }
        }.joinToString("")
    }

    fun newGame(): Status {
        return Status(currentWordAppearance = mask())
    }

    private fun getAllPositions(c: Char, word: String): Set<Int> {
        val positions = mutableSetOf<Int>()

        var index = word.indexOf(c)
        positions.add(index)
        while (index >= 0) {
            positions.add(index)
            index = word.indexOf(c, index + 1)
        }

        return positions
    }

    private fun prepareStatus(): Status {
        val maskedWord = mask()
        return Status(
            count = guessCount,
            guessedChars = guessedChars,
            currentWordAppearance = maskedWord,
            winner = !maskedWord.contains(maskedChar)
        )
    }

    private fun selectWordFamily(families: List<Family>): Family = families.maxBy { it.words.size }!!

    fun guess(c: Char): Status {
        println("Guessing $c")
        fun generateWordFamilies(): List<Family> {
            val families = mutableListOf<Family>()

            eligibleWords!!.forEach {
                val positions = getAllPositions(c, it)
                val familySet = families.find { family -> family.position == positions }
                if (familySet != null) {
                    val mutableList = familySet.words.toMutableList()
                    mutableList.add(it)
                    familySet.words = mutableList
                } else {
                    families.add(Family(positions, mutableListOf(it)))
                }
            }
            println(families)
            return families
        }

        if (c in guessedChars) {
            println("Character already guessed earlier.")
        } else {
            //Increment guessCount
            guessCount++

            //Add to guessed chars
            guessedChars.add(c)

            //generate word families
            val wordFamilies = generateWordFamilies()

            //select a word family
            val wordFamily = selectWordFamily(wordFamilies)

            //modify eligible words accordingly
            eligibleWords = wordFamily.words
            println("New eligible words $eligibleWords")

            //winner if actualWord is the guessedWord
        }
        return prepareStatus()
    }
}