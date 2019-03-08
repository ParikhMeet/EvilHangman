package mp.evilhangman

import java.io.File

class Dictionary {

    val words: List<String> = File(javaClass.classLoader.getResource("dictionary.txt").file).readLines()

    fun getWordMap(): Map<Int, List<String>> = words.groupBy({ it.length }, { it })

    fun getRandomLength(): Int = getWordMap().keys.random()
}

