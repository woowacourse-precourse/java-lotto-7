package lotto.validation;

import lotto.exception.LottoArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyValidationTest {

    @Test
    @DisplayName("로또 구매 총액 음수 테스트")
    void 로또_구매_총액_음수_테스트() {
        int amount = -1000;
        assertThatThrownBy(() -> MoneyValidation.isValidateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 총액 음수 테스트")
    void 로또_구매_총액_1000원_미만_테스트() {
        int amount = 900;
        assertThatThrownBy(() -> MoneyValidation.isValidateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 총액 음수 테스트")
    void 로또_구매_총액_1000원_단위_아닌_경우_테스트() {
        int amount = 15500;
        assertThatThrownBy(() -> MoneyValidation.isValidateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}