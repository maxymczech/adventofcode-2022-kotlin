import java.io.File
import java.io.BufferedReader

fun readTextFile(name: String): String {
  val bufferedReader: BufferedReader = File(name).bufferedReader()
  var str = bufferedReader.use { it.readText() }
  return str
}

fun main() {
    val str = readTextFile("day01.txt")
    val arr = str.split("\r\n\r\n").map{ it.lines().map{ it.toInt() }.sum() }.toIntArray()
    arr.sortDescending()

    // Part 1
    println(arr[0])

    // Part 2
    println(arr[0] + arr[1] + arr[2])
}
