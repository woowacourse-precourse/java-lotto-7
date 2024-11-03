package lotto.validator;

import lotto.common.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"-12, 13","12.","13a,14,15,16,17,18,19"})
    void 쉼표와_숫자_이외의_다른_문자를_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_CHARACTER);
    }

    @ParameterizedTest
    @ValueSource(strings={"1,2,3,4,5","1,2,3,4,5,6,7"})
    void 여섯개의_숫자를_입력하지_않으면_예외_발생(String input){
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings={"1,2,3,4,5,5","1,2,3,5,5,5"})
    void 중복된_숫자를_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.DUPLICATED_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings={"0,1,2,3,4,5","1,2,3,4,5,46","0,1,2,3,4,46"})
    void 로또범위를_벗어나는_숫자를_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_RANGE);
    }

}