package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Cashier;
import org.junit.jupiter.api.Test;

class CashierTest {
    @Test
    void 구입_금액_1000원_단위_예외() {
        Cashier cashier = new Cashier();
        assertThatThrownBy(() -> cashier.payPrice(2020))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
