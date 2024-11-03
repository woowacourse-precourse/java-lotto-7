package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.TestConstants.*;
import static lotto.common.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @Test
    @DisplayName("6개의 중복되지 않는 숫자를 넣으면 당첨 숫자가 잘 생성된다.")
    void getWinningNumbers () {
        // given
        String rawWinningNumbers = VALID_WINNING_NUMBERS;

        // when
        WinningNumbers winningNumbers = new WinningNumbers(rawWinningNumbers);

        // then
        assertTrue(winningNumbers.compareNumbers(WINNING_NUMBERS));
    }

    @Test
    @DisplayName("당첨 숫자가 숫자가 아닐 경우 에러를 반환한다.")
    void winningNumbersIsNotNumber () {
        // given
        String rawWinningNumbers = INVALID_WINNING_NUMBERS;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자 중 하나라도 1보다 작을 경우 에러를 반환한다.")
    void winningNumberIsUnderMax () {
        // given
        String rawWinningNumbers = UNDER_WINNING_NUMBERS_RANGE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자 중 하나라도 45를 넘을 경우 에러를 반환한다.")
    void winningNumberIsUpperMax () {
        // given
        String rawWinningNumbers = UP_WINNING_NUMBERS_RANGE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자의 개수가 6보다 작을 경우 에러를 반환한다.")
    void winningNumberSizeIsSmall () {
        // given
        String rawWinningNumbers = UNDER_WINNING_NUMBERS_SIZE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_LOTTO_SIZE, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자의 개수가 6보다 클 경우 에러를 반환한다.")
    void winningNumberSizeIsBig () {
        // given
        String rawWinningNumbers = UP_WINNING_NUMBERS_SIZE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_LOTTO_SIZE, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자가 중복될 경우 에러를 반환한다.")
    void winningNumberSizeIsDuplicated () {
        // given
        String rawWinningNumbers = DUPLICATED_WINNING_NUMBERS;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_DUPLICATE_WINNING_NUMBER, exception.getMessage());
    }

}