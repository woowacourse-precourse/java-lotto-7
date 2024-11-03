package lotto.global.util;

import static lotto.global.constant.ErrorMessage.LOTTO_PRICE_DIVISIBILITY;
import static lotto.global.constant.ErrorMessage.NUMBER_FORMAT_PROBLEM;
import static lotto.global.util.Validator.validatePrice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void 로또_구입_금액이_숫자_형식이_아닐_때_예외_발생() {
        //given
        String input = "hello";

        //then
        Assertions.assertThatThrownBy(() -> validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_PROBLEM);
    }

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않을_때_예외_발생() {
        //given
        String input = "1100";

        //then
        Assertions.assertThatThrownBy(() -> validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_PRICE_DIVISIBILITY);
    }

}