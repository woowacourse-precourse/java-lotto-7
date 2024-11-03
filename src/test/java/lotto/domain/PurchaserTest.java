package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PurchaserTest {

    @Test
    void 로또_구매했을때_정확한_갯수를_구매했는지_확인() {

        Budget testBudget = new Budget("3000");
        Purchaser testPurchaser = new Purchaser(testBudget);

        assertThat(testPurchaser.getPurchasedLotto().size()).isEqualTo(3);
    }
}