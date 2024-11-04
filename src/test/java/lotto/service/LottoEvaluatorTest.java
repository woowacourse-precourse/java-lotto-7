package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoEvaluatorTest {

    private LottoEvaluator lottoEvaluator;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lottoEvaluator = new LottoEvaluator();
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    void 로또등수계산_정확한등수반환() {
        //given
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto noRankLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        //when
        LottoRank firstRank = lottoEvaluator.determineLottoRank(firstRankLotto, winningLotto);
        LottoRank secondRank = lottoEvaluator.determineLottoRank(secondRankLotto, winningLotto);
        LottoRank thirdRank = lottoEvaluator.determineLottoRank(thirdRankLotto, winningLotto);
        LottoRank noRank = lottoEvaluator.determineLottoRank(noRankLotto, winningLotto);

        //then
        assertEquals(LottoRank.FIRST, firstRank);
        assertEquals(LottoRank.SECOND, secondRank);
        assertEquals(LottoRank.THIRD, thirdRank);
        assertEquals(LottoRank.OTHER, noRank);
    }

    @Test
    void 로또티켓목록등수카운트_정확한카운트반환() {
        //given
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto noRankLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));
        Iterable<Lotto> lottoTickets = Arrays.asList(firstRankLotto, secondRankLotto, thirdRankLotto, noRankLotto);

        //when
        Map<LottoRank, Integer> rankCounts = lottoEvaluator.evaluateLottoRankCounts(lottoTickets, winningLotto);

        //then
        assertEquals(1, rankCounts.get(LottoRank.FIRST));
        assertEquals(1, rankCounts.get(LottoRank.SECOND));
        assertEquals(1, rankCounts.get(LottoRank.THIRD));
        assertEquals(1, rankCounts.get(LottoRank.OTHER));
    }
}