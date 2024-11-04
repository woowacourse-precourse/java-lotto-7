package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.converter.BonusNumberConverter;
import lotto.utils.converter.PurchaseAmountConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberConverterTest {

    @Test
    void 문자열을_정수로_변환() {
        assertThat(BonusNumberConverter.convert("5"))
                .isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.1", "!@#$", "", "  "})
    void 정수가_아니면_예외_발생(String input) {
        assertThatThrownBy(() -> PurchaseAmountConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_INTEGER_PURCHASE_AMOUNT);
    }
}
