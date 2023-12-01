private val validNumbers = mapOf(
    "one" to "one1one",
    "two" to "two2two",
    "three" to "three3three",
    "four" to "four4four",
    "five" to "five5five",
    "six" to "six6six",
    "seven" to "seven7seven",
    "eight" to "eight8eight",
    "nine" to "nine9nine",
    )

fun main() {



    fun part1(input: List<String>): Int {
        val allNumbers = input.map {
            calibrationRaw -> calibrationRaw.filter { it.isDigit() }
        }.map { if (it.length == 1) it + it else it[0] + it.last().toString()  }

       return allNumbers.sumOf { it.toInt() }

    }

    fun part2(input: List<String>): Int {

        val linesWithNumbers = input.map { line ->
            var fixedLine = line
            validNumbers.forEach { (key, value) ->
                fixedLine = fixedLine.replace(key, value)
            }
            fixedLine
        }

        return part1(linesWithNumbers)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_input")

    part1(testInput).println()
    part2(testInput).println()
}