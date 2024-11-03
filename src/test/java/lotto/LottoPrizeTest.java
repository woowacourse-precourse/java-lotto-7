package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST;2,000,000,000", "FIFTH;5,000"}, delimiter = ';')
    void 상수_정상_동작_테스트_stringVer(LottoPrize grade, String expectedOutput) {
        assertEquals(expectedOutput, grade.getStringPrize());
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST;2000000000", "FIFTH;5000"}, delimiter = ';')
    void 상수_정상_동작_테스트_IntVer(LottoPrize grade, int expectedOutput) {
        assertEquals(expectedOutput, grade.getIntPrize());
    }
}
