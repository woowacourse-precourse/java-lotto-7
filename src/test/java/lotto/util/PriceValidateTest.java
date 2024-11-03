package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceValidateTest {

    PriceValidate priceValidate = new PriceValidate();

    @Test
    @DisplayName("구입금액_예외처리_테스트")
    void priceValidateTest() {
        String input = "5000";
        priceValidate.validate(input);
    }

    @Test
    @DisplayName("구입금액_예외처리_자료형_테스트")
    void priceCheckTypeTest() {
        String input = "String";
        assertThatThrownBy(() -> priceValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액_예외처리_최솟값_테스트")
    void priceCheckThousandUnit() {
        String input = "-5000";
        assertThatThrownBy(() -> priceValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액_예외처리_천원_단위_테스트")
    void priceCheckMinRangeTest() {
        String input = "5100";
        assertThatThrownBy(() -> priceValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}