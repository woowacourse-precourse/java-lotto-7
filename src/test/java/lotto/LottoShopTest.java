package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @Test
    void 로또_구매_개수_계산() {
        LottoShop lottoShop = new LottoShop();
        assertThat(lottoShop.calculatePurchaseCount(new PurchaseAmount("3000"))).isEqualTo(3);
    }
}
