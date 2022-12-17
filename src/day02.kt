import java.io.File
import java.io.BufferedReader

fun readTextFile(name: String): String {
  val bufferedReader: BufferedReader = File(name).bufferedReader()
  var str = bufferedReader.use { it.readText() }
  return str
}

fun main() {
  val data = readTextFile("day02.txt").lines()

  // Part 1
  val scoreMap1 = mapOf(
    "A X" to 4,
    "A Y" to 8,
    "A Z" to 3,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 7,
    "C Y" to 2,
    "C Z" to 6
  )
  println(data.map{ scoreMap1[it] }.sumOf{ it!! })

  // Part 2
  val scoreMap2 = mapOf(
    "A X" to 3,
    "A Y" to 4,
    "A Z" to 8,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 2,
    "C Y" to 6,
    "C Z" to 7
  )
  println(data.map{ scoreMap2[it] }.sumOf{ it!! })
}
