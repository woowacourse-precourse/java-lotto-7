package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {
    @Test
    void 올바른_구입_금액_검증_성공() {
        int amount = PurchaseAmountValidator.validate("5000");
        assertThat(amount).isEqualTo(5000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "100000000"})
    void 구입_금액이_범위를_벗어나면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "1523"})
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
