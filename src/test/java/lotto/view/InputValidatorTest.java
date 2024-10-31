package lotto.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}