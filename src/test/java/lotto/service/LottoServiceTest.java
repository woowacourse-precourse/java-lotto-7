package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void buyLotto() {
        int money = 10000;
        int lottoCount = money/1000;
        List<Lotto> lottos = lottoService.buyLotto(money);
        assertEquals(lottoCount, lottos.size());
    }
}