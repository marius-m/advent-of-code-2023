object TwoDigitWordsParser {

    val wordToNum = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
        // "zero" to 0, // not mentioned in the task
    )
    private val regexNumWords = wordToNum.keys
        .joinToString("|")
    private val regexNumAsWord = "($regexNumWords|[0-9])".toRegex()

    fun parseNum(input: String): Int {
        val regexMatch = regexNumAsWord.findAll(input) ?: return 0
        val matchValuesAsNum = regexMatch.toList()
            .map { wordToNumOrZero(it.value) }
        val valFirst = matchValuesAsNum.firstOrNull()
        val valLast = matchValuesAsNum.lastOrNull()
        if (valFirst == null || valLast == null) {
            return 0
        }
        return "$valFirst$valLast".toInt()
    }

    fun wordToNumOrZero(input: String): Int {
        val inputAsNum = input.toIntOrNull()
        if (inputAsNum != null) {
            return inputAsNum
        }
        return wordToNum
            .entries
            .firstOrNull { entry -> entry.key == input }?.value ?: 0
    }
}