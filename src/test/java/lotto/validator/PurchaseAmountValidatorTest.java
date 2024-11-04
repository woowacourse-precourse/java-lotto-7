package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountValidatorTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위이고 최소 1,000원 이상인 경우 통과")
    void validate_validAmount_shouldPass() {
        assertThatCode(() -> PurchaseAmountValidator.validate(5000))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외 발생")
    void validate_amountNotMultipleOfThousand_shouldThrowException() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(5500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 미만인 경우 예외 발생")
    void validate_amountBelowMinimum_shouldThrowException() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.");
    }
}
