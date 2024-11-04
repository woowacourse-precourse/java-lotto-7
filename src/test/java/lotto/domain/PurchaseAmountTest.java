package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseAmountTest {

    @Test
    void 구입_금액이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new PurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new PurchaseAmount(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_양수이고_1000원_단위인_경우_정상적으로_객체가_생성된다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        assertThat(purchaseAmount).isNotNull();
        assertThat(purchaseAmount.getAmount()).isEqualTo(5000);
    }
}
