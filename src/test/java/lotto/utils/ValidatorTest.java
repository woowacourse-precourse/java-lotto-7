package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 숫자를_입력하지_않으면_예외가_발생한다() {
        String amount = "1000원";

        assertThatThrownBy(() -> Validator.isNumber(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBER_MESSAGE);
    }

    @Test
    void 단위_1000으로_입력하지_않으면_예외가_발생한다() {
        int amount = 1500;

        assertThatThrownBy(() -> Validator.amountIsMultipleOf1000(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_AMOUNT_MESSAGE);
    }
}
