package lotto.validator;

import lotto.common.ErrorMessage;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {
    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp(){
        winningNumbers =new WinningNumbers(List.of(1,2,3,4,5,6));
    }

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