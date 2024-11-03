package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 구매한_로또_개수만큼_로또를_생성한다() {
        //given
        int lottoCount = 8;

        //when
        lottoService.generateLottos(lottoCount);

        //then
        List<Lotto> lottos = lottoService.getLottos();
        assertEquals(8, lottos.size());
    }
}