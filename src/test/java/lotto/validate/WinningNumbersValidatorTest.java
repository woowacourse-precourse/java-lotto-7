package lotto.validate;

import static org.assertj.core.api.Assertions.*;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,2,3,4,5,6", "ㄱ,2,3,4,5,6", "1!,2,3,4,5,6", "!,2,3,4,5,6"})
    void 입력_패턴_검증_테스트(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.getValidatedWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_PATTERN.getMessage());
    }

}
