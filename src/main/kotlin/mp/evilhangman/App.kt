package mp.evilhangman

fun main() {
    val evilHangman = EvilHangman()
    val newGame = evilHangman.newGame()
    println(newGame)
    evilHangman.guess('a')
}