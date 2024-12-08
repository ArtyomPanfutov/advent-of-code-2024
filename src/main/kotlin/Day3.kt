package org.example

fun main() {
    val testInputP1 = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    solveP1(getInput("/day3-input.txt"))
}
private fun solveP1(input: String) {
    val regex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()
    val ans = regex.findAll(input).sumOf {
        val (first, second) = it.destructured
        first.toLong() * second.toLong()
    }

    println(ans)
}