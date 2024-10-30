package lotto.validator;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {
    List<Integer> winningNumbers;

    @BeforeEach
    void setUp(){
        winningNumbers =List.of(1,2,3,4,5,6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 공백을_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.BLANK_OR_NULL_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","a","^","1+3"})
    void 양의_정수를_입력하지_않으면_예외_발생(String input){
        assertThatThrownBy(() ->  BonusNumberValidator.validateBonusNumber(input,winningNumbers)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","3"})
    void 당첨_번호와_같은_수를_입력하면_예외_발생(String input){
        assertThatThrownBy(() ->  BonusNumberValidator.validateBonusNumber(input,winningNumbers)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.DUPLICATED_TO_WINNING_NUMBERS);
    }

    @ParameterizedTest
    @ValueSource(strings={"0","46"})
    void 로또범위를_벗어나는_숫자를_입력하면_예외_발생(String input){
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(input,winningNumbers)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_RANGE);
    }



}