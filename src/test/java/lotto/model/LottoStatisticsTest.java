package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoStatistics;
import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.lottoCollection;
import lotto.model.rank.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {
    private LottoStatistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new LottoStatistics();
    }

    @Test
    @DisplayName("로또 통계 생성 시 모든 등급의 초기 개수가 0인지 확인")
    void initializeRankCounts() {
        for (LottoRank rank : LottoRank.values()) {
            assertEquals(0, statistics.getRankCounts().get(rank));
        }
    }

    @Test
    @DisplayName("모든 등수를 포함하는 로또 통계 계산 테스트")
    void calculateStatisticsForAllRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4등
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 5등
        );
        lottoCollection lottoCollection = new lottoCollection(lottos);

        statistics.calculate(lottoCollection, winningLotto);

        assertEquals(1, statistics.getRankCounts().get(LottoRank.FIRST));
        assertEquals(1, statistics.getRankCounts().get(LottoRank.SECOND));
        assertEquals(1, statistics.getRankCounts().get(LottoRank.THIRD));
        assertEquals(1, statistics.getRankCounts().get(LottoRank.FOURTH));
        assertEquals(1, statistics.getRankCounts().get(LottoRank.FIFTH));
    }

    @Test
    @DisplayName("수익률 계산이 정확하게 작동하는지 확인")
    void earningsRateCalculation() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)) // 1등 당첨
        );
        lottoCollection lottoCollection = new lottoCollection(lottos);

        statistics.calculate(lottoCollection, winningLotto);

        double earningsRate = statistics.calculateEarningsRate(1000); // 구매 금액이 1000원일 때 수익률 계산
        assertTrue(earningsRate > 1000000.0);
    }

}
