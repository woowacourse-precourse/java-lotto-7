package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void 로또번호_생성() {
        PurchasePrice purchasePrice = new PurchasePrice(4000);
        Lottos lottos = new Lottos(purchasePrice);
        assertThat(lottos.lottoCount()).isEqualTo(4);
    }
}
