fun main() {

    fun parseMatches(input: List<String>): List<List<Map<String, Int>>> = input.mapIndexed { _, game ->
        game.substringAfter(": ")
            .split("; ")
            .map { round ->
                round.split(", ")
                    .associate { colorAndCount ->
                        colorAndCount.split(" ").let { (count, color) -> color to count.toInt() }
                    }
            }
    }

    fun part1(input: List<String>): Int {
        val matchs = parseMatches(input)
        return matchs
            .withIndex()
            .filter { (_, rounds) ->
                rounds.all { colorsFoRound ->
                    colorsFoRound.getOrDefault("red", 0) <= 12
                    && colorsFoRound.getOrDefault("green", 0) <= 13
                    && colorsFoRound.getOrDefault("blue", 0) <= 14
                }
            }.sumOf { (index) -> index + 1 }
    }
    
    fun part2(input: List<String>): Int {
        val matches = parseMatches(input)
        return matches.map { match ->
            match.asSequence()
                    .flatMap {
                        it.asSequence()
                    }.groupBy({ it.key }, { it.value })

        }.map { it.values.toTypedArray().map { it.max() } }.sumOf {
            var power = 1
            it.map {
                power *= it
            }
            power
        }
    }
    
    val testInput = readInput("Day02_input")

    part1(testInput).println()
    part2(testInput).println()
}