package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.purchase.PurchaseAmountConverter;
import lotto.utils.ErrorMessages;
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
