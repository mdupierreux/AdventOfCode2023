fun main() {
    fun part1(input: List<String>): Int {
        input.forEach { game ->
            val gameId = game.substringBefore(":").substringAfter("Game ")
            val reveal = gameId
        }
        return input.size
    }
    
    fun part2(input: List<String>): Int {
        return input.size
    }
    
    val testInput = readInput("Day02_input")

    part1(testInput).println()
    part2(testInput).println()
}