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
           .map { it.substringAfter(": ")}
           .map { it.split("|") }
           .map { Pair(stringToInt(it[0]), stringToInt(it[1])) }
           .map { it.first.intersect(it.second) }
           .filter { it.isNotEmpty() }
           .sumOf { 2.toDouble().pow(it.size - 1)  }
           .toInt()
    }

    fun part2(input: List<String>): Int {

        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_input")

    part1(testInput).println()
    part2(testInput).println()
}