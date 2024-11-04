package lotto.view.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumberTest {

    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        lottoWinningNumber = new LottoWinningNumber();
    }

    @Test
    @DisplayName("올바른 당첨 번호 입력 시 예외 발생하지 않음")
    void validateValidWinningNumbers() {
        assertDoesNotThrow(() -> lottoWinningNumber.validateWinningNumbersForTest("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46", "1,1,2,3,4,5"})
    @DisplayName("잘못된 당첨 번호 입력 시 예외 발생")
    void validateInvalidWinningNumbers(String invalidInput) {
        assertThrows(IllegalArgumentException.class,
            () -> lottoWinningNumber.validateWinningNumbersForTest(invalidInput));
    }

    @Test
    @DisplayName("올바른 보너스 번호 입력 시 예외 발생하지 않음")
    void validateValidBonusNumber() {
        assertDoesNotThrow(() ->
            lottoWinningNumber.validateBonusNumberForTest("7", "1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @CsvSource({
        "0,1,2,3,4,5,6",
        "46,1,2,3,4,5,6",
        "1,1,2,3,4,5,6"
    })
    @DisplayName("잘못된 보너스 번호 입력 시 예외 발생")
    void validateInvalidBonusNumber(String bonusNumber, String winningNumbers) {
        assertThrows(IllegalArgumentException.class,
            () -> lottoWinningNumber.validateBonusNumberForTest(bonusNumber, winningNumbers));
    }

    @Test
    @DisplayName("숫자가 아닌 입력 시 예외 발생")
    void validateNonNumericValue() {
        assertThrows(IllegalArgumentException.class,
            () -> lottoWinningNumber.validateWinningNumbersForTest("1,2,3,4,5,a"));
    }
}