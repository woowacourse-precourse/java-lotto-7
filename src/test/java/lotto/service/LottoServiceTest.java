package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoServiceImpl lottoService;

    @BeforeEach
    void setUp() {
        lottoService = LottoServiceImpl.getInstance();
    }

    @Test
    void buyLotto() {
        int lottoCount = 10;
        List<Lotto> lottos = lottoService.buyLotto(lottoCount);
        assertEquals(lottoCount, lottos.size());
    }
}