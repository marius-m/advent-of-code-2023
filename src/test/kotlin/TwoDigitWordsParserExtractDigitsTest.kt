import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoDigitWordsParserExtractDigitsTest {
    @Test
    fun empty() {
        val input = ""
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "",
                digits = "",
            ),
            result,
        )
    }

    @Test
    fun zero() {
        val input = "00"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "00",
                digits = "00",
            ),
            result,
        )
    }

    @Test
    fun oneZero() {
        val input = "1zero"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "1zero",
                digits = "1",
            ),
            result,
        )
    }

    @Test
    fun one() {
        val input = "01"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "01",
                digits = "01",
            ),
            result,
        )
    }

    @Test
    fun oneone() {
        val input = "11"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "11",
                digits = "11",
            ),
            result,
        )
    }

    @Test
    fun basic1() {
        val input = "1abc2"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "1abc2",
                digits = "12",
            ),
            result,
        )
    }

    @Test
    fun basic2() {
        val input = "pqr3stu8vwx"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "pqr3stu8vwx",
                digits = "38",
            ),
            result,
        )
    }

    @Test
    fun basic3() {
        val input = "a1b2c3d4e5f"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "a1b2c3d4e5f",
                digits = "12345",
            ),
            result,
        )
    }

    @Test
    fun oneNum() {
        val input = "treb7uchet"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "treb7uchet",
                digits = "7",
            ),
            result,
        )
    }

    @Test
    fun noNum() {
        val input = "trebuchet"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "trebuchet",
                digits = "",
            ),
            result,
        )
    }

    @Test
    fun wordsBetween() {
        val input = "two1nine"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "two1nine",
                digits = "219",
            ),
            result,
        )
    }

    @Test
    fun onlyWords() {
        val input = "eightwothree"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "eightwothree",
                digits = "823",
            ),
            result,
        )
    }

    @Test
    fun words1() {
        val input = "abcone2threexyz"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "abcone2threexyz",
                digits = "123",
            ),
            result,
        )
    }

    @Test
    fun words2() {
        val input = "xtwone3four"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "xtwone3four",
                digits = "2134",
            ),
            result,
        )
    }

    @Test
    fun words3_numsFromSides() {
        val input = "4nineeightseven2"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "4nineeightseven2",
                digits = "49872",
            ),
            result,
        )
    }

    @Test
    fun words4_mix() {
        val input = "zoneight234"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "zoneight234",
                digits = "18234",
            ),
            result,
        )
    }

    @Test
    fun words5_mix() {
        val input = "7pqrstsixteen"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "7pqrstsixteen",
                digits = "76",
            ),
            result,
        )
    }

    @Test
    fun overlapping1() {
        val input = "zoneightfive8nine2one6"
        val result = TwoDigitWordsParser.extractDigitsOverlapping(input)
        assertEquals(
            TwoDigitWordsParser.DigitString(
                original = "zoneightfive8nine2one6",
                digits = "18589216",
            ),
            result,
        )
    }
}