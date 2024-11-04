package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new LottoStatistics();
    }

    @Test
    @DisplayName("로또 결과 기록 테스트")
    void recordWinTest() {
        statistics.recordWin(LottoResult.FIVE_MATCH);
        statistics.recordWin(LottoResult.FIVE_BONUS_MATCH);

        Map<LottoResult, Integer> stats = statistics.getStatistics();
        assertThat(stats.get(LottoResult.FIVE_MATCH)).isEqualTo(1);
        assertThat(stats.get(LottoResult.FIVE_BONUS_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 구매 비용 추가 테스트")
    void addCostTest() {
        statistics.addCost(3000);
        assertThat(statistics.getTotalCost()).isEqualTo(3000);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateYieldTest() {
        statistics.addCost(3000);
        statistics.recordWin(LottoResult.FIVE_MATCH);

        double yield = statistics.calculateYield();
        assertThat(yield).isGreaterThan(0);
    }
}
