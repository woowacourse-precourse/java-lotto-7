package lotto.domain.purchase;

import lotto.domain.play.LottoGenerator;
import lotto.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {
    private static final int PRICE = 1000;
    private static final LottoGenerator DUMMY_GENERATOR = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));
    @DisplayName("주어진 금액에 따른 로또의 갯수를 생성하는지 확인")
    @Test
    void purchaseLottoWith() {
        int lottoPurchaseCount = 5;
        int moneyValue = lottoPurchaseCount * PRICE;
        LottoMoney money = LottoMoney.of(moneyValue);
        LottoShop lottoShop = new LottoShop(DUMMY_GENERATOR);

        List<Lotto> purchaseLotto = lottoShop.purchaseLottoWith(money);

        assertThat(purchaseLotto).hasSize(lottoPurchaseCount);
    }
}