package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
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
        Lottos lottos = lottoService.createLottos(COUNT);

        // then
        assertEquals(lottos.getLottos().size(), COUNT);
    }

    @Test
    void 당첨된_내역을_기준으로_수익률을_계산한다() {
        // given
        Integer count = 3000;
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FIRST, Rank.NONE);

        // when
        double revenueRate = lottoService.calculateRevenue(ranks, count);

        // then
        Assertions.assertEquals(66666833.3, revenueRate);
    }
}
