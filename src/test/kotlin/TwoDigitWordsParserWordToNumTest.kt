import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoDigitWordsParserWordToNumTest {

    @Test
    fun empty() {
        val input = ""
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(0, result)
    }

    @Test
    fun one() {
        val input = "one"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(1, result)
    }

    @Test
    fun two() {
        val input = "two"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(2, result)
    }

    @Test
    fun three() {
        val input = "three"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(3, result)
    }

    @Test
    fun four() {
        val input = "four"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(4, result)
    }

    @Test
    fun five() {
        val input = "five"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(5, result)
    }

    @Test
    fun six() {
        val input = "six"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(6, result)
    }

    @Test
    fun seven() {
        val input = "seven"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(7, result)
    }

    @Test
    fun eight() {
        val input = "eight"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(8, result)
    }

    @Test
    fun nine() {
        val input = "nine"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(9, result)
    }

    @Test
    fun zero() {
        val input = "0"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(0, result)
    }

    @Test
    fun invalid() {
        val input = "invalid"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(0, result)
    }

    @Test
    fun validNum() {
        val input = "1"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(1, result)
    }

    @Test
    fun validNum2() {
        val input = "2"
        val result = TwoDigitWordsParser.wordToNumOrZero(input)
        assertEquals(2, result)
    }

    @Test
    fun allWordValues() {
        TwoDigitWordsParser.wordToNum.forEach { entry ->
            val result = TwoDigitWordsParser.wordToNumOrZero(entry.key)
            assertEquals(entry.value, result)
        }
    }
}