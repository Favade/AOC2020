import java.io.File

const val WON = 6
const val DRAW = 3


//PART ONE COMPLETED

fun main() {
    var totalScore = 0

    val fileName = "rps.txt"
    val file = File(fileName)

     val rpsFile = file.readLines()
     for (line in rpsFile) {
         val opponentOne = line.toCharArray().first()
         val opponentTwo = line.toCharArray().last()
         val a = moves(opponentOne)
         val b = moves(opponentTwo)
         totalScore += round(a, b)
     }

    println(totalScore)
}

fun moves(move: Char): String  = when(move) {
    'A', 'X' -> "Rock"
    'B', 'Y' -> "Paper"
    'C', 'Z'-> "Scissors"
    else -> throw IllegalArgumentException("Invalid move")
}

fun shape(shape: String): Int = when(shape) {
    "Rock" -> 1
    "Paper" -> 2
    "Scissors" -> 3
    else -> throw IllegalArgumentException("Invalid")
}

fun isWin(shapeOne: String, shapeTwo: String): Boolean  {
    when(shapeOne) {
        "Rock" -> if (shapeTwo == "Paper")  return  true
        "Paper" -> if (shapeTwo == "Scissors")  return  true
        "Scissors" -> if (shapeTwo == "Rock")  return  true
    }

    return false
}

fun isDraw(shapeOne: String, shapeTwo: String): Boolean = shapeOne == shapeTwo

fun round(shapeOne: String, shapeTwo: String):Int {
    var points = 0

    if (isWin(shapeOne, shapeTwo)) {
        points += shape(shapeTwo) + WON
        return points
    }
     if (isDraw(shapeOne, shapeTwo)) {
         points += shape(shapeTwo) + DRAW
        return points
    }

    return 0 + shape(shapeTwo)
}