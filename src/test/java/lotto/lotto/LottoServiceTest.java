package lotto.lotto;

import java.util.List;
import lotto.random.RandomImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService(new RandomImpl());

    @Test
    void purchaseLottoWithAmount() {
        // given
        int price = 8000;

        // when
        List<Lotto> lottos = lottoService.purchaseLottoWithAmount(price);

        // then
        Assertions.assertEquals(8, lottos.size());
    }
}