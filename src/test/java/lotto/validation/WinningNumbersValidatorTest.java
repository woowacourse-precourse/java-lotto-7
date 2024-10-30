package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {
    WinningNumbersValidator validator = new WinningNumbersValidator();

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("입력값이 존재하는지 검증")
    void 입력값이_존재해야_한다(String input) {
        assertThatThrownBy(() -> validator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2,3,4", "1,2,,3", "12,13.14,15"})
    @DisplayName("입력값이 쉼표로 구분되었는지 검증")
    void 입력값은_쉼표로_구분되어야_한다(String input) {
        assertThatThrownBy(() -> validator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,44,46,3", "1,5,0,21,34"})
    @DisplayName("입력값의 숫자가 유효한 범위인지 검증")
    void 입력값의_숫자는_유효한_범위여야_한다(String input) {
        assertThatThrownBy(() -> validator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "34,35,36,37,38,39,40", "1,2,3"})
    @DisplayName("입력값의 숫자가 유효한 개수인지 검증")
    void 입력값의_숫자는_유효한_개수여야_한다(String input) {
        assertThatThrownBy(() -> validator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
