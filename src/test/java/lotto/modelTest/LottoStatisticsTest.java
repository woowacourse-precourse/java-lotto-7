package lotto.modelTest;

import lotto.model.LottoStatistics;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    public void shouldInitializeStatistics() {
        LottoStatistics statistics = new LottoStatistics();
        assertThat(statistics.getStatistics().get("3개 일치 (5,000원)")).isEqualTo(0);
        assertThat(statistics.getStatistics().get("4개 일치 (50,000원)")).isEqualTo(0);
    }

    @Test
    public void shouldIncrementStatistics() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.increment("3개 일치 (5,000원)");
        assertThat(statistics.getStatistics().get("3개 일치 (5,000원)")).isEqualTo(1);
    }

    @Test
    public void shouldCalculateTotalEarnings() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.increment("3개 일치 (5,000원)");
        statistics.increment("4개 일치 (50,000원)");
        statistics.increment("5개 일치 (1,500,000원)");
        statistics.increment("5개 일치, 보너스 볼 일치 (30,000,000원)");
        statistics.increment("6개 일치 (2,000,000,000원)");

        double totalEarnings = statistics.calculateTotalEarnings();
        // 각 등수별 수익 계산
        double expectedEarnings = (1 * 5000) + (1 * 50000) + (1 * 1500000) +
                (1 * 30000000) + (1 * 2000000000);

        assertThat(totalEarnings).isEqualTo(expectedEarnings);
    }
}
