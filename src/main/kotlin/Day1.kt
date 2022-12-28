import java.io.File

fun main() {
    val fileName = "input.txt"
    val file = File(fileName).readLines()
    val arr = mutableListOf<Int>()
    var max = Int.MIN_VALUE
    var sum = 0
    for (line in file) {
        if (line != "") {
            sum += line.toInt()
            arr.add(sum)
        } else {
            sum *= 0
        }
    }
    println(arr.sortedDescending().take(3).sum())


//    for (i in arr.indices) {
//        max = maxOf(max, arr[i])
//    }
//    println(max)

}

