import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoDigitParserTest {
    @Test
    fun empty() {
        val input = ""
        val result = TwoDigitOnlyParser.parseNum(input)
        assertEquals(0, result)
    }

    @Test
    fun basic1() {
        val input = "1abc2"
        val result = TwoDigitOnlyParser.parseNum(input)
        assertEquals(12, result)
    }

    @Test
    fun basic2() {
        val input = "pqr3stu8vwx"
        val result = TwoDigitOnlyParser.parseNum(input)
        assertEquals(38, result)
    }

    @Test
    fun basic3() {
        val input = "a1b2c3d4e5f"
        val result = TwoDigitOnlyParser.parseNum(input)
        assertEquals(15, result)
    }

    @Test
    fun oneNum() {
        val input = "treb7uchet"
        val result = TwoDigitOnlyParser.parseNum(input)
        assertEquals(77, result)
    }

    @Test
    fun noNum() {
        val input = "trebuchet"
        val result = TwoDigitOnlyParser.parseNum(input)
        assertEquals(0, result)
    }
}