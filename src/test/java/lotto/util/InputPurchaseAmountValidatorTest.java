package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputPurchaseAmountValidatorTest {

    final Validator validator = new InputPurchaseAmountValidator();

    @Test
    void notNumberTest() {
        //given
        String input = "숫자가아님";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasMinimumTest() {
        // given
        String input = "999";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nullTest() {
        // given
        String input = null;
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isDivisibleByMinimumAmountTest() {
        // given
        String input = "1999";
        // when & then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}