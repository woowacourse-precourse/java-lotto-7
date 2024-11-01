package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Purchase;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    @Test
    void 천워이하단위_에러테스트() {
        assertThatThrownBy(() -> new Purchase(1111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또구매개수_테스트() {
        Purchase purchase = new Purchase(20000);
        assertEquals(purchase.calculatePurchasableLotto(), 20);
    }
}
