package lotto;

import lotto.validator.Validators;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorsTest {

    private final Validators validators = new Validators();

    @DisplayName("구매 금액 단위는 1000원이 아닌경우 예외처리한다.")
    @Test
    void 구매_단위_1000원_아니면_예외처리() {
        int price = 1100;

        Assertions.assertThatThrownBy(() -> validators.validatePurchaseAmountUnit(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
