package lotto.domain;

import static lotto.util.Constants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PurchaseLottosTest {
    @Test
    void 로또_목록_저장() {
        PurchaseLottos purchaseLottos = new PurchaseLottos();
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        List<Lotto> result = purchaseLottos.saveAll(lottos);
        assertThat(result).containsExactlyElementsOf(lottos);
    }

    @Test
    void 로또_개수_반환() {
        PurchaseLottos purchaseLottos = new PurchaseLottos();
        purchaseLottos.saveAll(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12))));

        int count = purchaseLottos.findLottoCount();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void 총_구입_금액_계산() {
        PurchaseLottos purchaseLottos = new PurchaseLottos();
        purchaseLottos.saveAll(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12))));

        int totalAmount = purchaseLottos.purchaseAmount();
        assertThat(totalAmount).isEqualTo(2 * LOTTO_PRICE);
    }
}
