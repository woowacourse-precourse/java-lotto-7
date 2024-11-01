package lotto.purchase;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseNumberTest {

    @Test
    void 로또_구매_횟수_저장_테스트() {
        PurchaseNumber purchaseNumber = new PurchaseNumber("2000");

        assertThat(purchaseNumber).isEqualTo(new PurchaseNumber(2));
    }

    @Test
    void 로또_구매_실패_테스트() {
        assertThatThrownBy(() -> new PurchaseNumber("2500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
