package lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import lotto.service.LottoService;
import lotto.service.RevenueCalculator;
import lotto.service.strategy.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomStrategy());
        lottoService = new LottoService(lottoGenerator, new RevenueCalculator());
    }

    @Test
    void 사용자의_입력만큼_로또가_발행되어야한다() {
        // given
        Integer COUNT = 5;

        // when
        Lottos lottos = lottoService.generateLottos(COUNT);

        // then
        assertEquals(lottos.getLottos().size(), COUNT);
    }
}
