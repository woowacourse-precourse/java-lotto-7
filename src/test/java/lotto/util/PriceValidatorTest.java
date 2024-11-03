package lotto.util;

import lotto.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"","a1","1  0","1-1"})
    void 숫자_외의_문자_입력시_검증_실패(String input) {
        Assertions.assertThatThrownBy(() -> PriceValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_FORM.format());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","1001"})
    void 나눠떨어지지_않는_입력시_검증_실패(String input) {
        Assertions.assertThatThrownBy(() -> PriceValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.format());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000","10101000"})
    void 구매_금액_검증_통과(String input){
        PriceValidator.validate(input);
    }

}