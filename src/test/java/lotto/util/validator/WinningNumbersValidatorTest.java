package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @DisplayName("당첨번호를 입력받을 때 빈 문자열을 입력받을 수 없다.")
    @ParameterizedTest
    @EmptySource
    void inputEmptyString(String rawWinningNumbers) {

        assertThatThrownBy(() -> WinningNumbersValidator.validate(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호를 입력할 때 빈 문자열을 입력할 수 없습니다. 다시 시도해 주세요.");
    }

    @DisplayName("당첨 번호를 입력할 때 숫자와 콤마만 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3e", "qwffw, fwf,q", "1ae", "1a2", "1,2!,3"})
    void inputWithOtherChar(String rawWinningNumbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호를 입력할 때 숫자와 콤마만 입력할 수 있습니다. 다시 시도해 주세요.");
    }

    @DisplayName("당첨 번호를 입력할 때 콤마를 연속적으로 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,,2", ",,", ",,1"})
    void commaNextComma(String rawWinningNumbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호를 입력할 때 콤마를 연속적으로 입력할 수 없습니다. 다시 시도해 주세요.");
    }

}