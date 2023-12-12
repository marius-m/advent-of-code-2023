import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    val inputFile = File("input.txt")
    if (!inputFile.exists())
        throw IllegalArgumentException("Must provide an input file!")

    // Reading lines from kotlin
    val inputNums = inputFile
        .bufferedReader(Charsets.UTF_8)
        .readLines()
        .map { inputLine -> TwoDigitParser.parseNum(inputLine) }
    val sumOfNums = inputNums.sum()

    println("Input nums: ${inputNums}")
    println("Sum: ${sumOfNums}")
}