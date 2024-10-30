package lotto.validator;

import lotto.common.ErrorMessage;
import lotto.domain.PaymentInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"12, 13","12.","13a"})
    void 쉼표와_숫자_이외의_다른_문자를_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_CHARACTER);
    }

}