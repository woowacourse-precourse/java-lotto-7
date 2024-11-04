package lotto.purchase.domain;

import java.util.Map;
import lotto.lotto.domain.value.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseResultTest {

    @Test
    @DisplayName("PurchaseResult객체를 생성한다.")
    void testPurchaseResult() {
        // given
        Money money = Money.of(1000);
        Purchase purchase = Purchase.of("lotto", money);
        Map<LottoRank, Long> winningMap = Map.of(LottoRank.MATCHED3, 1L);

        // when
        PurchaseResult purchaseResult = PurchaseResult.of(purchase, 5000, winningMap);

        //then
        Assertions.assertThat(purchaseResult.getPurchase()).isEqualTo(purchase);
        Assertions.assertThat(purchaseResult.getWinningInfo()).isEqualTo(winningMap);
        Assertions.assertThat(purchaseResult.getRateOfReturn()).isEqualTo(500.0);
    }
}