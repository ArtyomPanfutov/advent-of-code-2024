package org.example

import kotlin.math.abs

val testInput =
"""
    3   4
    4   3
    2   5
    1   3
    3   9
    3   3
""".trimIndent()

fun parseInput(input: String): List<Pair<Int, Int>> =
    input.lines().map { toPair(it) }

fun toPair(line: String): Pair<Int, Int> {
    val t = line.trim()
    val idx = t.indexOf("   ")
    return Pair(
        t.substring(0, idx).toInt(),
        t.substring(idx + 3, t.length).toInt()
    )
}

fun main() {
    solveP1()
    solveP2()
}

fun solveP2() {
    val pairs = parseInput(getInput("/day-input.txt"))
    val right = pairs.map { it.second }
    val freq = mutableMapOf<Int, Int>()
    right.forEach {
        val v = freq.getOrDefault(it, 0)
        freq[it] = v + 1
    }
    val rs = pairs.map { it.first }.sumOf { it * freq.getOrDefault(it, 0) }

    println(rs)
}

private fun solveP1() {
    val pairs = parseInput(getInput("/day-input.txt"))
    val left = pairs.map { it.first }.sorted()
    val right = pairs.map { it.second }.sorted()

    val rs = left.mapIndexed { i, v -> abs(v - right[i]) }.sum()
    println(rs)
}