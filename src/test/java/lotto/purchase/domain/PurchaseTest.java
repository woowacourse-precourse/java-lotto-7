package lotto.purchase.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {

    @Test
    @DisplayName("Purchase 객체를 생성한다.")
    void createPurchase() {
        // given
        Money money = Money.of(1000);

        // when
        Purchase purchase = Purchase.of("lotto", money);

        //then
        Assertions.assertThat(purchase.getId()).isInstanceOf(String.class);
        Assertions.assertThat(purchase.getMoney()).isEqualTo(money);
        Assertions.assertThat(purchase.getLottoResultId()).isEqualTo("lotto");
    }
}