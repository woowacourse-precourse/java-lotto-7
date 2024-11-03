package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest(name = "{0} 의 10회 당첨 시 총 상금은 {1}")
    @CsvSource(value = {
            "FIRST_PLACE:20000000000",
            "SECOND_PLACE:300000000",
            "THIRD_PLACE:15000000",
            "FOURTH_PLACE:500000",
            "FIFTH_PLACE:50000"
    }, delimiter = ':')
    void 당첨_테스트_10회기준(Prize prize, long expected) {
        //when
        long result = prize.calculateTotalPrizeMoney(10);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @EnumSource(Prize.class)
    void 당첨횟수는_음수가_될_수_없다(Prize prize) {
        //given
        int wrongCount = -1;
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> prize.calculateTotalPrizeMoney(wrongCount))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @EnumSource(Prize.class)
    void 당첨횟수는_10억을_초과할_수_없다(Prize prize) {
        //given
        int wrongCount = 1000000001;
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> prize.calculateTotalPrizeMoney(wrongCount))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}