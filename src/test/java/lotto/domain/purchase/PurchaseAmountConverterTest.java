package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.ErrorMessages;
import lotto.utils.converter.PurchaseAmountConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.1", "!@#$", "", "  "})
    void 정수가_아니면_예외_발생(String input) {
        assertThatThrownBy(() -> PurchaseAmountConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_INTEGER_PURCHASE_AMOUNT);
    }
}
