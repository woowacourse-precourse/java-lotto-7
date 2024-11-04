package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasePriceTest {
    private static final String UNIT = "1000";
    private static final String BIGGER_THAN_ZERO = "0원보다 커야됩니다";


    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 구입금액이_양수가_아님_실패(int price) {
        assertThatThrownBy(() -> new PurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BIGGER_THAN_ZERO);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1024, 9999, 10500})
    void 구입금액이_1000단위가_아님_실패(int price) {
        assertThatThrownBy(() -> new PurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNIT);
    }
}
