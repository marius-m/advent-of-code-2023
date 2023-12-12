import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoDigitWordsParserTest {
    @Test
    fun empty() {
        val input = ""
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(0, result)
    }

    @Test
    fun zero() {
        val input = "00"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(0, result)
    }

    @Test
    fun oneZero() {
        val input = "1zero"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(11, result)
    }

    @Test
    fun one() {
        val input = "01"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(1, result)
    }

    @Test
    fun oneone() {
        val input = "11"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(11, result)
    }

    @Test
    fun basic1() {
        val input = "1abc2"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(12, result)
    }

    @Test
    fun basic2() {
        val input = "pqr3stu8vwx"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(38, result)
    }

    @Test
    fun basic3() {
        val input = "a1b2c3d4e5f"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(15, result)
    }

    @Test
    fun oneNum() {
        val input = "treb7uchet"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(77, result)
    }

    @Test
    fun noNum() {
        val input = "trebuchet"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(0, result)
    }

    @Test
    fun wordsBetween() {
        val input = "two1nine"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(29, result)
    }

    @Test
    fun onlyWords() {
        val input = "eightwothree"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(83, result)
    }

    @Test
    fun words1() {
        val input = "abcone2threexyz"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(13, result)
    }

    @Test
    fun words2() {
        val input = "xtwone3four"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(24, result)
    }

    @Test
    fun words3_numsFromSides() {
        val input = "4nineeightseven2"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(42, result)
    }

    @Test
    fun words4_mix() {
        val input = "zoneight234"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(14, result)
    }

    @Test
    fun words5_mix() {
        val input = "7pqrstsixteen"
        val result = TwoDigitWordsParser.parseNum(input)
        assertEquals(76, result)
    }
}