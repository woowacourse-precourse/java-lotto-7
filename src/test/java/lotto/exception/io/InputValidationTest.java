package lotto.exception.io;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    @DisplayName("입력이 null 이거나 빈 값이라면 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullOrEmpty(String input) {
        //when //then
        assertThatThrownBy(() -> InputValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getErrorMessage());
    }

    @DisplayName("숫자가 아닌 문자가 입력되면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "?", "-", "1000원"})
    void inputNumeric(String input) {
        //when //then
        assertThatThrownBy(() -> InputValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMERIC.getErrorMessage());
    }

    @DisplayName("입력에 공백이 있다면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "1000 원", " 1000원", "1000원 "})
    void inputContainBlank(String input) {
        //when //then
        assertThatThrownBy(() -> InputValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_CONTAIN_BLANK.getErrorMessage());
    }

    @DisplayName("입력이 null 또는 빈값이 아니고, 공백이 없이 숫자로만 되어있다면 예외를 발생하지 않는다.")
    @Test
    void input() {
        //given
        String input = "8000";

        //when //then
        assertThatCode(() -> InputValidation.validate(input))
                .doesNotThrowAnyException();
    }
}
