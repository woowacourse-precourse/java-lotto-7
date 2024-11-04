package lotto.model;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsCalculatorTest {
    @DisplayName("로또 결과 확인 테스트")
    @Test
    void checkLottoTest() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<LottoResult> results = StatisticsCalculator.checkLotto(lottos, winningLotto);

        assertEquals(6, results.get(0).getWinningResult());
        assertFalse(results.get(0).isBonusResult());
        assertEquals(0, results.get(1).getWinningResult());
        assertTrue(results.get(1).isBonusResult());
    }

    @DisplayName("당첨 횟수 계산 테스트")
    @Test
    void calculateRankCountsTest() {
        List<LottoResult> results = List.of(
                new LottoResult(6, false),
                new LottoResult(5, true),
                new LottoResult(5, false),
                new LottoResult(4, false),
                new LottoResult(3, false)
        );
        RankStorage rankStorage = new RankStorage();
        StatisticsCalculator.calculateRankCounts(results, rankStorage);

        assertEquals(1, rankStorage.getRankCount(1));
        assertEquals(1, rankStorage.getRankCount(2));
        assertEquals(1, rankStorage.getRankCount(3));
        assertEquals(1, rankStorage.getRankCount(4));
        assertEquals(1, rankStorage.getRankCount(5));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateRateReturnTest() {
        LottoAmount lottoAmount = new LottoAmount(8000);
        RankStorage rankStorage = new RankStorage();
        rankStorage.increaseRankCount(3);
        double rateReturn = StatisticsCalculator.calculateRateReturn(lottoAmount, rankStorage);

        assertEquals(18750.0, rateReturn);
    }
}
