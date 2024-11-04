package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @DisplayName("로또 금액에 맞게 로또를 구매한다.")
    @Test
    void 로또_금액에_맞게_로또를_구매한다() {
        int buyMoney = 5000;

        List<Lotto> lottos = lottoService.buyLottos(buyMoney);

        int expectedCount = buyMoney / 1000;
        assertEquals(expectedCount, lottos.size());
    }
}
