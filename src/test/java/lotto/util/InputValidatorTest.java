package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외 발생")
    void validatePurchaseAmount_notMultipleOfThousand_throwsException() {
        int amount = 1500;
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 미만이면 예외 발생")
    void validatePurchaseAmount_lessThanThousand_throwsException() {
        int amount = 500;
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위이면 통과")
    void validatePurchaseAmount_validAmount_passes() {
        int amount = 5000;
        assertThatCode(() -> InputValidator.validatePurchaseAmount(amount))
                .doesNotThrowAnyException();
    }
}

