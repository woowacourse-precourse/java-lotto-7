package lotto.domain.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultFactoryTest {
    LottoMachine lottoMachine;
    List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
        lottoMachine.assignWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoMachine.assignBonusNumber(7);

        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),        // 6개 일치 (1등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),        // 5개 + 보너스 일치 (2등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),        // 5개 일치 (3등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)),      // 4개 일치 (4등)
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),      // 3개 일치 (5등)
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13))     // 0개 일치 (꽝)
        );
    }

    @Test
    void 로또_당첨_조회() {
        Result result = ResultFactory.generateResult(lottoMachine, lottos);

        assertEquals(1, result.getWinningCount(Rank.FIRST_PRIZE));
        assertEquals(1, result.getWinningCount(Rank.SECOND_PRIZE));
        assertEquals(1, result.getWinningCount(Rank.THIRD_PRIZE));
        assertEquals(1, result.getWinningCount(Rank.FOURTH_PRIZE));
        assertEquals(1, result.getWinningCount(Rank.FIFTH_PRIZE));
    }
}