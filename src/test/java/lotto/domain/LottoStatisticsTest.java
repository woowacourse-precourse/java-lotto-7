package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @DisplayName("로또 통계 생성 성공 테스트")
    @Test
    void makeLottoStatistics_success() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // THIRD
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // FOURTH
                new Lotto(List.of(1, 2, 3, 8, 10, 11)) // FIFTH
        );

        lottoStatistics.make(lottos, winningLotto);

        Map<LottoRanking, Integer> rankingCount = lottoStatistics.getRankingCount();
        assertThat(rankingCount.getOrDefault(LottoRanking.FIRST, 0)).isEqualTo(1);
        assertThat(rankingCount.getOrDefault(LottoRanking.SECOND, 0)).isEqualTo(1);
        assertThat(rankingCount.getOrDefault(LottoRanking.THIRD, 0)).isEqualTo(1);
        assertThat(rankingCount.getOrDefault(LottoRanking.FOURTH, 0)).isEqualTo(1);
        assertThat(rankingCount.getOrDefault(LottoRanking.FIFTH, 0)).isEqualTo(1);
    }

    @DisplayName("총 상금 계산 성공 테스트")
    @Test
    void calculateTotalPrize_success() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );

        lottoStatistics.make(lottos, winningLotto);

        int totalPrize = lottoStatistics.calculateTotalPrize();
        int expectedTotalPrize = LottoRanking.FIRST.getPrize()
                + LottoRanking.SECOND.getPrize()
                + LottoRanking.THIRD.getPrize();

        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}
