package lotto.service;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.TestConstants.VALID_WINNING_NUMBERS;
import static lotto.TestConstants.WINNING_NUMBERS;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersServiceTest {
    private final WinningNumbersService winningNumbersService = new WinningNumbersService();
    @Test
    @DisplayName("당첨 번호가 잘 생성된다.")
    void getWinningNumbers () {
        // given
        String inputWinningNumbers = VALID_WINNING_NUMBERS;

        // when
        WinningNumbers winningNumbers = winningNumbersService.getWinningNumbers(inputWinningNumbers);

        // then
        assertTrue(winningNumbers.compareNumbers(WINNING_NUMBERS));
    }

}