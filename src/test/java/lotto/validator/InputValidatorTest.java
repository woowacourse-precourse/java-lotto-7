package lotto.validator;

import lotto.model.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    @DisplayName("구매금액 입력은 단일 정수여야 한다.")
    void validateSingleNumberInput() {
        String price = "10000";
        Assertions.assertThatNoException().isThrownBy(() -> InputValidator.validateSingleNumberInput(price));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1", "abc100.", "1 1"})
    @DisplayName("단일 정수가 아닌 값을 입력한 경우 예외가 발생한다")
    void invalidSingleNumberInput(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateSingleNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_TYPE.getMessage());
    }

    @Test
    @DisplayName("공백만 입력한 경우 예외가 발생한다")
    void invalidEmptyPriceInput() {
        String input = " ";
        Assertions.assertThatThrownBy(() -> InputValidator.validateSingleNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_VALUE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 입력은 정수와 쉼표(,)로 구성된 문자열이어야 한다")
    void validateWinNumbers() {
        String input = "1,2,3,4,5";
        Assertions.assertThatNoException().isThrownBy(() -> InputValidator.validateWinNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4", "1.1,2,3", "1 1"})
    @DisplayName("정수와 쉼표(,)만으로 구성된 문자열이 아닌 값을 입력한 경우 예외가 발생한다")
    void invalidWinNumbersInput(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_LIST.getMessage());
    }

    @Test
    @DisplayName("단일 정수가 아닌 값을 입력한 경우 예외가 발생한다")
    void invalidEmptyWinNumberInput() {
        String input = " ";
        Assertions.assertThatThrownBy(() -> InputValidator.validateSingleNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_VALUE.getMessage());
    }
}