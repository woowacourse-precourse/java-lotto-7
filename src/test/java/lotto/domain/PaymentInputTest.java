package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentInputTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 공백을_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> new PaymentInput(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.BLANK_OR_NULL_INPUT);
    }


    @ParameterizedTest
    @ValueSource(strings = {"+1","-1",".!3","1.5"})
    void 숫자가_아닌_값을_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> new PaymentInput(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT);
    }

}