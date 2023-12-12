object TwoDigitParser {
    fun parseNum(input: String): Int {
        val onlyNum = input.filter { it.isDigit() }
        val valFirst = onlyNum.firstOrNull()
        val valLast = onlyNum.lastOrNull()
        if (valFirst == null || valLast == null) {
            return 0
        }
        return "$valFirst$valLast".toInt()
    }
}