package lotto.util.validator;

import static lotto.util.message.OutputMessage.ERROR_MESSAGE;
import static lotto.util.validator.InputValidator.validateBlank;
import static lotto.util.validator.InputValidator.validateLongInt;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTests {

    @ParameterizedTest
    @DisplayName("빈 문자열이나 공백만 포함된 문자열 입력 시 예외 발생")
    @ValueSource(strings = {"", "    "})
    void validateBlankExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateBlank(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 문자 포함 시 예외 발생")
    @ValueSource(strings = {"1e9", "1000E", "e", "2.0"})
    void validateLongIntExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateLongInt(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("문자열을 정수로 변환한 값이 양의 정수가 아니면 예외 발생")
    @ValueSource(strings = {"-1", "0"})
    void validatePositiveIntegerExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validateLongInt(input))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}