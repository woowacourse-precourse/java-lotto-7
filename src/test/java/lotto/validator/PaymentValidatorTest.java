package lotto.validator;

import lotto.common.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 공백을_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> PaymentValidator.validateRawPayment(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.BLANK_OR_NULL_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"99999999999999999999999999","1.5^"})
    void 숫자가_아닌_값을_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> PaymentValidator.validateRawPayment(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_INPUT_TYPE);
    }

}