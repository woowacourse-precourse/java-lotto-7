package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {
    @Test
    void 구입금액_생성() {
        PurchasePrice purchasePrice = new PurchasePrice(1000);
        assertThat(purchasePrice).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {900, 1300})
    void 구입금액_예외처리(int value) {
        assertThatThrownBy(() -> new PurchasePrice(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
