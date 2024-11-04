package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 구입금액만큼_로또를_구매한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        Lottos lottos = new Lottos(purchaseAmount);
        int buyCount = lottos.getCount();

        assertThat(buyCount).isEqualTo(5);
    }
}
