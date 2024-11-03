package lotto.entity;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {

    @Test
    @DisplayName("유효한 메인 숫자와 보너스 번호로 WinningNumbers 생성")
    void createWinningNumbersWithValidNumbers() {
        List<Integer> mainNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);

        assertEquals(mainNumbers, winningNumbers.getMainNumbers());
        assertEquals(bonusNumber, winningNumbers.getBonusNumber());
    }

    @Test
    @DisplayName("메인 숫자가 6개가 아닐 때 예외 발생")
    void throwExceptionWhenMainNumbersCountIsInvalid() {
        List<Integer> mainNumbers = List.of(1, 2, 3, 4, 5); // 숫자 개수가 5개
        int bonusNumber = 7;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(mainNumbers, bonusNumber));
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage(), exception.getMessage());
    }
}
