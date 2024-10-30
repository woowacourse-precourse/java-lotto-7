package lotto.validator;

import lotto.common.ErrorMessage;
import lotto.domain.BonusNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 공백을_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.BLANK_OR_NULL_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","a","^","1+3"})
    void 양의_정수를_입력하지_않으면_예외_발생(String input){
        assertThatThrownBy(() ->  BonusNumberValidator.validateBonusNumber(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT);
    }

}