package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountInputValidatorTest {

    @ParameterizedTest
    @DisplayName("구매 금액을 공백을 입력했을 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    void throwsExceptionIsBlank(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmount(amount),
                "[ERROR] 값을 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 양의 정수가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "0", "-2"})
    void throwsExceptionIsNotPositiveInteger(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmount(amount),
                "[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = "1003")
    void throwsExceptionIsInvalidUnit(String amount) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmount(amount),
                "[ERROR] 금액은 1000원 단위로 입력해주세요.");
    }

}
