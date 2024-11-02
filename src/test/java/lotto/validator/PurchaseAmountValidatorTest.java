package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @DisplayName("로또 구입 금액은 1000으로 나누어 떨어지는 양의 정수여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1000", "10010"})
    void validatePurchaseAmount(String purchaseAmount) {
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}