package lotto.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("구입 금액이 null 또는 비어 있을 경우 예외 발생 테스트")
    void 구입_금액이_null_또는_비어있을_때_예외_발생(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validatePurchaseAmount(amount),
                "[ERROR] 입력값은 비어 있지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000.50", "1000a"})
    @DisplayName("구입 금액이 정수가 아닌 경우 예외 발생 테스트")
    void 구입_금액이_정수가_아닐_때_예외_발생(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validatePurchaseAmount(amount),
                "[ERROR] 입력값은 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "500", "1000"})
    @DisplayName("유효한 구입 금액일 때 예외 발생하지 않음")
    void 유효한_구입_금액일_때_예외_미발생(String amount) {
        assertDoesNotThrow(() -> InputValidator.validatePurchaseAmount(amount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("당첨 번호가 null 또는 비어 있을 경우 예외 발생 테스트")
    void 당첨_번호가_null_또는_비어있을_때_예외_발생(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumbers(winningNumbers),
                "[ERROR] 입력값은 비어 있지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3 4,5,6", "1:2:3:4:5:6"})
    @DisplayName("당첨 번호가 쉼표로 구분되어 있지 않을 경우 예외 발생 테스트")
    void 당첨_번호가_쉼표로_구분되어_있지_않을_때_예외_발생(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumbers(winningNumbers),
                "[ERROR] 입력값은 쉼표(,)로 구분된 6개의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1,2,3,4,5,1.5"})
    @DisplayName("당첨 번호가 정수가 아닌 경우 예외 발생 테스트")
    void 당첨_번호가_정수가_아닐_때_예외_발생(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumbers(winningNumbers),
                "[ERROR] 입력값은 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7,8"})
    @DisplayName("당첨 번호가 6개의 숫자가 아닌 경우 예외 발생 테스트")
    void 당첨_번호가_6개의_숫자가_아닐_때_예외_발생(String winningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateWinningNumbers(winningNumbers),
                "[ERROR] 입력값은 쉼표(,)로 구분된 6개의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,50,60"})
    @DisplayName("유효한 당첨 번호일 경우 예외 발생하지 않음")
    void 유효한_당첨_번호일_때_예외_미발생(String winningNumbers) {
        assertDoesNotThrow(() -> InputValidator.validateWinningNumbers(winningNumbers));
    }
}