package lotto.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.config.LottoConstants.LOTTO_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("구매 금액에 따른 로또 수 일치")
    @Test
    void buyLottos_ShouldReturnCorrectNumberOfLottos_WhenGivenPurchaseAmount() {
        int purchaseAmount = 5000;
        int expectedLottoCount = purchaseAmount / LOTTO_PRICE.getValue();

        List<Lotto> lottos = Lotto.buyLottos(purchaseAmount);

        assertEquals(expectedLottoCount, lottos.size(), "구매 금액에 따라 로또 수가 정확해야 합니다.");
    }

    @DisplayName("모든 로또 번호가 유일한가")
    @Test
    void buyLottos_ShouldReturnUniqueLottos() {
        int purchaseAmount = 3000;
        int lottoCount = purchaseAmount / LOTTO_PRICE.getValue();

        List<Lotto> lottos = Lotto.buyLottos(purchaseAmount);

        assertEquals(lottoCount, lottos.size(), "로또 수는 구매한 수와 일치해야 합니다.");

        Set<Lotto> uniqueLottos = new HashSet<>(lottos);
        assertEquals(uniqueLottos.size(), lottos.size(), "모든 로또 번호는 유일해야 합니다.");
    }
}
