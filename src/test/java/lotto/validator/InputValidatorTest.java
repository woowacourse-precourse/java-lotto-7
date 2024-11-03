package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Nested
    class 숫자_입력_검증 {

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" "})
        void 숫자_입력은_비거나_공백으로_이루어진_문자열일_수_없다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "123abc", "!@#", "12.34"})
        void 숫자_입력은_정수_형식만_허용한다(String input) {
            // when & then
            assertThatThrownBy(() -> InputValidator.validateInteger(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }
}