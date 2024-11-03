package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyValidatorTest {

    @Test
    public void 올바른_형식의_구매_금액() {
        assertEquals(10000, MoneyValidator.validate("10000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "1000원", "만원", " ", ""})
    void 구매_금액을_양수로_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> MoneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void 구매_금액을_천원단위로_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> MoneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}