package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void 입력_시_공백이_입력되면_예외가_발생한다(String input) {
        //given
        final String expectedMessage = "[ERROR] 입력은 공백이 아닌 숫자여야 합니다.";

        //when & then
        assertThatThrownBy(() -> InputValidator.validateBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"14 000", " 7", "1, 2, 3, 4, 5, 6"})
    void 입력_시_공백이_함께_입력되면_예외가_발생한다(String input) {
        //given
        final String expectedMessage = "[ERROR] 입력은 공백이 포함되지 않은 입력이어야 합니다.";

        //when & then
        assertThatThrownBy(() -> InputValidator.validateWhitespace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}