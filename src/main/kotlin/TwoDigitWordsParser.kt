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

    /**
     * Works, but the task does not detect overlapping functionality
     * For overlapping, use [extractDigitsOverlapping]
     */
    fun extractDigits(input: String): DigitString {
        val regexMatch = regexNumAsWord.findAll(input)
        val matchValuesAsNum = regexMatch.toList()
            .map { wordToNumOrZero(it.value) }
            .joinToString(separator = "")
        return DigitString(
            original = input,
            digits = matchValuesAsNum,
        )
    }

    fun extractDigitsOverlapping(input: String): DigitString {
        var index = 0
        var digits = ""
        while (index < input.length) {
            val regexMatch = regexNumAsWord.find(input, index)
            if (regexMatch != null) {
                digits += wordToNumOrZero(regexMatch.value)
                index = regexMatch.range.first + 1
                continue
            }
            index++
        }
        return DigitString(
            original = input,
            digits = digits,
        )
    }

    /**
     * Failing, need more info, moved to [extractDigits]
     */
    @Deprecated("First try, does not work")
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

    data class DigitString(
        val original: String,
        val digits: String,
    ) {
        val firstOrNull: Int? = digits.firstOrNull()
            ?.digitToIntOrNull()
        val firstOrZero: Int = firstOrNull ?: 0
        val lastOrNull: Int? = digits.lastOrNull()
            ?.digitToIntOrNull()
        val lastOrZero: Int = lastOrNull ?: 0

        val twoDigits: Int = "$firstOrZero$lastOrZero".toInt()

        fun isEmpty(): Boolean = firstOrNull == null || lastOrNull == null
    }
}