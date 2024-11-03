package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {
    private static final int PURCHASE_UNIT = 1000;

    @Test
    void 구입금액만큼_로또를_발행한다() {
        // given
        int purchaseAmount = 5000;
        Lottos lottos = new Lottos();

        // when
        lottos.issueByAmount(purchaseAmount);
        
        // then
        int expectedQuantity = purchaseAmount / PURCHASE_UNIT;
        Assertions.assertThat(lottos.size()).isEqualTo(expectedQuantity);
    }
}
