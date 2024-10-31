package lotto.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("입력값이 null 또는 비어 있을 경우 예외 발생 테스트")
    void 입력값이_null_또는_비어있을_때_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNotBlank(input),
                "[ERROR] 입력값은 비어 있지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000.50", "1000"})
    @DisplayName("입력값이 null 또는 비어 있지 않을 경우 예외 발생하지 않음")
    void 입력값이_null_또는_비어있지_않을_때_예외_미발생(String input) {
        assertDoesNotThrow(() -> InputValidator.validateNotBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000.50", "1000a"})
    @DisplayName("입력값이 정수가 아닌 경우 예외 발생 테스트")
    void 입력값이_정수가_아닐_때_예외_발생(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInteger(input),
                "[ERROR] 입력값은 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000", "-1000"})
    @DisplayName("입력값이 정수일 경우 예외 발생하지 않음")
    void 입력값이_정수일_때_예외_미발생(String input) {
        assertDoesNotThrow(() -> InputValidator.validateInteger(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 1500, -1000})
    @DisplayName("입력값이 1,000원 단위가 아닐 경우 예외 발생 테스트")
    void 입력값이_1000원_단위가_아닐_때_예외_발생(int amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateThousandUnit(amount),
                "[ERROR] 입력값은 1,000원 단위의 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 10000})
    @DisplayName("입력값이 1,000원 단위일 경우 예외 발생하지 않음")
    void 입력값이_1000원_단위일_때_예외_미발생(int amount) {
        assertDoesNotThrow(() -> InputValidator.validateThousandUnit(amount));
    }
}