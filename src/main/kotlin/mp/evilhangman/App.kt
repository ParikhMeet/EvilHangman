package mp.evilhangman

fun main() {
    val dictionary = Dictionary()
    println(dictionary.words.size)
    println(dictionary.getWordMap()[2])
    println(dictionary.getRandomLength())
    println(dictionary.getRandomLength())
    println(dictionary.getRandomLength())
}