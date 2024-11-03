package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.common.Exceptions;
import lotto.view.input.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @Test
    @DisplayName("[success] 양의 정수 10자리 이하 값을 입력한다.")
    void inputNormalInteger() {
        String testString = "50";

        assertThatCode(() -> InputValidator.validateInputInteger(testString))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[입력값 공통 예외 1] null을 입력하면 예외가 발생한다.")
    void fail_IfInputValueIsNull() {
        String nullValue = null;

        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(nullValue))
                .withMessage(Exceptions.EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[입력값 공통 예외 2] 빈 문자열을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    void fail_IfInputValueIsBlank(String blankValue) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(blankValue))
                .withMessage(Exceptions.EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[양의 정수 입력값 공통 예외 1] 정수가 아닌 값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"-20.2, -1.0, 0.5, 2.0, 2.5, 3.24321"})
    void fail_IfInputValueNonInteger(String nonIntegerNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(nonIntegerNumber))
                .withMessage(Exceptions.NOT_POSITIVE_INTEGER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[양의 정수 입력값 공통 예외 2] 양수가 아닌 값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"-20, -1, 0"})
    void 금액이_양수가_아니면_예외(String nonPositiveNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(nonPositiveNumber))
                .withMessage(Exceptions.NOT_POSITIVE_INTEGER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[양의 정수 입력값 공통 예외 3] 10자리를 초과하는 값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"10000000000", "123456789123456789"})
    void 금액이_10자리를_넘어가면_예외(String overRangeNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> InputValidator.validateInputInteger(overRangeNumber))
                .withMessage(Exceptions.OUT_OF_INTEGER_RANGE.getMessage());
    }
}
