package mp.evilhangman

import java.io.File

object Dictionary {

    private val words: List<String> = File(javaClass.classLoader.getResource("dictionary.txt").file).readLines()

    val wordMap: Map<Int, List<String>> = words.groupBy({ it.length }, { it })

}
