fun main() {
    
    fun waysToWin(time: List<Long>, distance: List<Long>) =
        time.zip(distance).map {
            (time, distance) -> (0..time).map { (time - it) * it }.count { it > distance }
        }.reduce { acc, i -> acc * i }.toLong()
    
    fun part1(input: List<String>): Long {
        return input.map { it.substringAfter(" ") }
            .map { it.split(" ").mapNotNull {
                it.toLongOrNull()
            }
        }.let { waysToWin(it[0], it[1]) }
    }

    fun part2(input: List<String>): Long {
        val time = input[0].substringAfter(" ").replace(" ", "").toLong()
        val distance = input[1].substringAfter(" ").replace(" ", "").toLong()
        return waysToWin(listOf(time), listOf(distance))
    }

    val testInput = readInput("Day06_input")

    part1(testInput).println()
    part2(testInput).println()
}
