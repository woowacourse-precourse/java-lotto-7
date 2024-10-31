package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @Test
    @DisplayName("구입 가능한 로또 개수가 올바른지 확인한다.")
    void 구입_가능한_로또_개수가_올바른지_확인한다() {
        LottoManager lottoManager = new LottoManager();
        int expect = 5;

        int numOfLotto = lottoManager.getBuyableCount(new Money(5500));

        assertEquals(numOfLotto, expect);
    }

    @Test
    @DisplayName("로또를 구입한 후 받았는지 확인한다.")
    void 로또를_구입한_후_받았는지_확인한다() {
        LottoManager lottoManager = new LottoManager();
        int expect = 5;

        lottoManager.buyLotto(new Store(), new Money(5500));
        List<Lotto> lottos = lottoManager.getLottos();

        assertEquals(lottos.size(), 5);
    }
}