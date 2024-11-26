package lotto.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("정수 입력값이 null 또는 비어 있을 경우 예외 발생 테스트")
    void 입력값이_null_또는_비어있을_때_예외_발생(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNotBlankAndInteger(amount),
                ErrorMessage.INPUT_NOT_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000.50", "1000a"})
    @DisplayName("정수 입력값이 정수가 아닌 경우 예외 발생 테스트")
    void 입력값이_정수가_아닐_때_예외_발생(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNotBlankAndInteger(amount),
                ErrorMessage.INPUT_INTEGER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "500", "1000"})
    @DisplayName("유효한 정수 입력값일 때 예외 발생하지 않음")
    void 유효한_구입_금액일_때_예외_미발생(String amount) {
        assertDoesNotThrow(() -> InputValidator.validateNotBlankAndInteger(amount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("당첨 번호가 null 또는 비어 있을 경우 예외 발생 테스트")
    void 당첨_번호가_null_또는_비어있을_때_예외_발생(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumbers(winningNumbers),
                ErrorMessage.INPUT_NOT_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1,2,3,4,5,1.5"})
    @DisplayName("당첨 번호가 정수가 아닌 경우 예외 발생 테스트")
    void 당첨_번호가_정수가_아닐_때_예외_발생(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumbers(winningNumbers),
                ErrorMessage.INPUT_INTEGER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,50,60"})
    @DisplayName("유효한 당첨 번호일 경우 예외 발생하지 않음")
    void 유효한_당첨_번호일_때_예외_미발생(String winningNumbers) {
        assertDoesNotThrow(() -> InputValidator.validateWinningNumbers(winningNumbers));
    }
}