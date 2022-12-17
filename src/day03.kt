import java.io.File
import java.io.BufferedReader

fun readTextFile(name: String): String {
  val bufferedReader: BufferedReader = File(name).bufferedReader()
  var str = bufferedReader.use { it.readText() }
  return str
}

fun priority(c: Char): Int {
  val sub = if (c.isUpperCase()) 38 else 96
  return c.code - sub;
}

fun main() {
  val data = readTextFile("day03.txt").lines()

  // Part 1
  println(
    data
      .map{ it.chunked(it.length / 2) }
      .map{
        val left = it[0]
        val right = it[1]
        left.chunked(1).find{ right.contains(it) }
      }
      .map{ priority(it!![0]) }
      .sumOf{ it }
  )

  // Part 2
  var total = 0;
  for (i in 0..data.size-1 step 3) {
    val c = data[i].chunked(1).find{
      data[i + 1].chunked(1).contains(it) && data[i + 2].chunked(1).contains(it)
    };
    total += priority(c!![0]);
  }
  println(total);
}
