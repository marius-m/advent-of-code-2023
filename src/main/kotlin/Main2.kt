import java.io.File

fun main(args: Array<String>) {
    val inputFile = File("input2.txt")
    if (!inputFile.exists())
        throw IllegalArgumentException("Must provide an input file!")

    // Reading lines from kotlin
    val inputLines = inputFile
        .bufferedReader(Charsets.UTF_8)
        .readLines()
    val sw = System.currentTimeMillis()
    val digits = inputLines.map { inputLine ->
            val digitString = TwoDigitWordsParser.extractDigitsOverlapping(inputLine)
            println("'$inputLine' -> ${digitString.digits}")
            digitString.twoDigits
        }
    val sumOfNums = digits.sum()
    println("sw: ${System.currentTimeMillis() - sw}ms")
    println("Sum: ${sumOfNums}")
}