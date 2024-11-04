package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("빈 문자열이나 null이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void validateEmptyInput(String input) {
        assertThatThrownBy(() -> InputValidator.parsePositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 비어있습니다.");
    }

    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "12a", "!@#"})
    void validateNonNumericInput(String input) {
        assertThatThrownBy(() -> InputValidator.parsePositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("쉼표로 구분된 6개의 숫자를 파싱한다")
    @Test
    void parseValidNumbers() {
        String input = "1,2,3,4,5,6";
        assertThat(InputValidator.parseNumbers(input))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("6개가 아닌 개수의 숫자가 입력되면 예외가 발생한다")
    @Test
    void validateInvalidNumberCount() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> InputValidator.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 입력해야 합니다.");
    }
}