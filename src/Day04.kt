import kotlin.math.pow

fun main() {
    
    fun stringToInt(input: String): Set<Int> {
        return input.trim()
            .split(" ")
            .filter(String::isNotEmpty)
            .map ( String::toInt )
            .toSet()
    }
    
    fun part1(input: List<String>): Int {
       return input
               .asSequence()
               .map { it.substringAfter(": ")}
           .map { it.split("|") }
           .map { Pair(stringToInt(it[0]), stringToInt(it[1])) }
           .map { it.first.intersect(it.second) }
           .filter { it.isNotEmpty() }
           .sumOf { 2.toDouble().pow(it.size - 1)  }
           .toInt()
    }

    fun part2(input: List<String>): Int {
        val cards = input
            .map { it.substringAfter(": ")}
            .map { it.split("|") }
            .map { Pair(stringToInt(it[0]), stringToInt(it[1])) }

        val counts = cards.map { 1 }.toMutableList()

        cards.forEachIndexed { index, card ->
            val score = card.first.intersect(card.second).count()
            for (i in index + 1  ..< index + 1 + score) {
                counts[i] += counts[index]
            }
        }

        return counts.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_input")

    part1(testInput).println()
    part2(testInput).println()
}