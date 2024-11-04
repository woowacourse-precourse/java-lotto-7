package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.WinningNumbersErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @Test
    void WinningNumbers_생성_테스트() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // when
        List<Integer> result = winningNumbers.getWinningNumbers();

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void getWinningNumbers_당첨번호_반환() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        // when
        List<Integer> result = winningNumbers.getWinningNumbers();

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void validateIsNumberAndComma_숫자와_쉼표_이외_문자는_예외() {
        assertThatThrownBy(() -> {
            // given
            String rawInput = "1,2,3,4,5,6abc";

            // when
            WinningNumbers winningNumbers = new WinningNumbers(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningNumbersErrorMessage.ONLY_NUMBER_AND_COMMAS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,,4,5,6", "1,2,3,4,5,6,", ",1,2,3,4,5,6"})
    void validateIsNestedComma_연속콤마_시작_끝_콤마_예외(String rawInput) {
        assertThatThrownBy(() -> {
            // when
            WinningNumbers winningNumbers = new WinningNumbers(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningNumbersErrorMessage.INVALID_COMMA.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validateIsSixElement_로또번호_6개_아님_예외(String rawInput) {
        assertThatThrownBy(() -> {
            // when
            WinningNumbers winningNumbers = new WinningNumbers(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningNumbersErrorMessage.INVALID_NUMBERS_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,0"})
    void validateIsElementInRange_로또_범위_예외(String rawInput) {
        assertThatThrownBy(() -> {
            // when
            WinningNumbers winningNumbers = new WinningNumbers(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningNumbersErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void validateIsUnique_로또_번호_중복_예외() {
        assertThatThrownBy(() -> {
            // given
            String rawInput = "1,2,3,4,5,5";
            // when
            WinningNumbers winningNumbers = new WinningNumbers(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningNumbersErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

}