package lotto.domain;

import static lotto.config.ErrorMessageConstant.PURCHASE_REMINDER_MESSAGE;
import static lotto.config.ErrorMessageConstant.PURCHASE_TOO_LOW_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void 최소_주문금액_미충족() {
        String purchase = "500";
        assertThatThrownBy(() -> new Money(purchase))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_TOO_LOW_MESSAGE);
    }

    @Test
    void 거스름돈_발생() {
        String purchase = "1001";
        assertThatThrownBy(() -> new Money(purchase))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_REMINDER_MESSAGE);
    }
}