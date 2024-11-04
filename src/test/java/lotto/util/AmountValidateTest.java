package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountValidateTest {

    AmountValidate amountValidate = new AmountValidate();

    @Test
    @DisplayName("구입금액_예외처리_테스트")
    void amountValidateTest() {
        String input = "5000";
        amountValidate.validate(input);
    }

    @Test
    @DisplayName("구입금액_예외처리_자료형_테스트")
    void amountCheckTypeTest() {
        String input = "String";
        assertThatThrownBy(() -> amountValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액_예외처리_최솟값_테스트")
    void amountCheckThousandUnit() {
        String input = "-5000";
        assertThatThrownBy(() -> amountValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액_예외처리_천원_단위_테스트")
    void amountCheckMinRangeTest() {
        String input = "5100";
        assertThatThrownBy(() -> amountValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}