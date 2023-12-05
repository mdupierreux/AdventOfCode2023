fun main() {
    fun getMaps(input: List<String>): List<Map<LongRange, LongRange>> =
        input.drop(2).joinToString("\n").split("\n\n").map { section ->
            section.lines().drop(1).associate { it ->
                it.split(" ").map { it.toLong() }.let { (dest, source, length) ->
                    source..(source + length) to dest..(dest + length)
                }
            }
        }

    fun part1(input: List<String>): Int {
        val seeds = input.first().substringAfter(" ").split(" ").map { it.toLong() }
        val maps = getMaps(input)
        return seeds.minOf { seed ->
            maps.fold(seed) { inital, map ->
                map.entries.firstOrNull { inital in it.key }?.let { (source, dest) -> dest.first + (inital - source.first) } ?: inital
            }
        }.toInt()
    }
    
    fun part2(input: List<String>): Int {
        val seeds = input.first().substringAfter(" ")
            .split(" ")
            .map { it.toLong() }
            .chunked(2)
            .map {
                it.first()..<it.first() + it.last()
            }
        val maps = getMaps(input)
        return seeds.flatMap { seedsRange ->
            maps.fold(listOf(seedsRange)) { initial, map ->
                initial.flatMap {
                    map.entries.mapNotNull { (source, dest) ->
                        (maxOf(source.first, it.first) to minOf(source.last, it.last)).let { (start, end) ->
                            if (start <= end) (dest.first - source.first).let { (start + it)..(end + it) } else null
                        }
                    }
                }
            }
        }.minOf { it.first }.toInt()
    }
    
    val testInput = readInput("Day05_input")

    part1(testInput).println()
    part2(testInput).println()
}

    