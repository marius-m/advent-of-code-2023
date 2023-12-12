import java.io.File

fun main(args: Array<String>) {
    val inputFile = File("input1.txt")
    if (!inputFile.exists())
        throw IllegalArgumentException("Must provide an input file!")

    // Reading lines from kotlin
    val inputNums = inputFile
        .bufferedReader(Charsets.UTF_8)
        .readLines()
        .map { inputLine ->
            val num = TwoDigitOnlyParser.parseNum(inputLine)
            println("'$inputLine' -> $num")
            num
        }
    val sumOfNums = inputNums.sum()
    println("Sum: ${sumOfNums}")
}