package org.example

import kotlin.math.abs

fun main() {
    Day2().solveP1()
}

class Day2 {

    private val testInput =
        """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent()

    fun solveP1() {
        val reports = parseInput(getInput("/day2-input.txt"))

        println(reports.count { safe(it) })
    }

    private fun parseInput(input: String) = input.lines().map {
        val nums = mutableListOf<Int>()
        var num = 0
        for (ch in it) {
            if (ch.isDigit()) {
                num *= 10
                num += ch.digitToInt()
            } else {
                if (num != 0) {
                    nums.add(num)
                    num = 0
                }
            }
        }
        if (num != 0) {
            nums.add(num)
            num = 0
        }
        nums
    }

    private fun safe(level: List<Int>): Boolean {
        if (level.isEmpty()) {
            return false
        }
        var l = 0
        var r = 1
        val increasing = level[r] > level[l]
        while (r <= level.size - 1) {
            if (level[l] > level[r] && increasing) {
                return false
            }
            if (level[l] < level[r] && !increasing) {
                return false
            }
            val delta = abs(level[r] - level[l])
            if (delta > 3 || delta < 1) {
                return false
            }
            l++
            r++
        }
        return true
    }
}