package lotto;

import lotto.exception.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 구입금액이_빈값인지_확인한다(String input){
        assertThatThrownBy(() -> InputValidator.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"55g5,3215g,6t123","ttsads"})
    void 구입금액이_숫자인지_확인한다(String input){
        assertThatThrownBy(() -> InputValidator.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
    }
}
