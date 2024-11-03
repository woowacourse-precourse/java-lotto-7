package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("입력값이 비어있거나 공백문자로 구성된 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "\n"})
    void validateNonBlank(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateNonBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 비어 있거나 공백으로만 구성되었습니다.");
    }

    @DisplayName("입력된 당첨 번호가 쉼표로 구분되지 않은 경우, 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1;2;3;4;5;6", "1/2/3/4/5/6"})
    void validateDelimitedByComma(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateDelimitedByComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호 입력 시, 쉼표(,)로 구분해야 합니다.");
    }
}
