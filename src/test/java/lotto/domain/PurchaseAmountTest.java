package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    void 구입금액이_0이상이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_1000단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(12500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_개수를_반환한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        assertThat(purchaseAmount.getCountPerUnit()).isEqualTo(8);
    }

    @Test
    void 구입금액을_반환한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        assertThat(purchaseAmount.getValue()).isEqualTo(8000);
    }
}
