package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoStatisticsTest {


    @DisplayName("등수 추가시 해당 등수의 카운트가 증가한다")
    @Test
    void 각_등수별_당첨_횟수를_저장한다() {
        LottoStatistics stats = new LottoStatistics();

        stats.addRank(Rank.FIFTH);
        stats.addRank(Rank.FIFTH);

        assertThat(stats.getRankCount(Rank.FIFTH)).isEqualTo(2);
    }

    @DisplayName("총 당첨금액 계산")
    @Test
    void 총_당첨금액_계산() {
        LottoStatistics stats = new LottoStatistics();

        stats.addRank(Rank.FIFTH);  // 5,000원
        stats.addRank(Rank.FOURTH); // 50,000원

        assertThat(stats.calculateTotalPrize()).isEqualTo(55000);
    }

    @DisplayName("수익률을 정확히 계산한다")
    @Test
    void calculateProfitRate() {
        LottoStatistics stats = new LottoStatistics();

        stats.addRank(Rank.FIFTH);  // 5,000원

        assertThat(stats.calculateProfitRate(10000)).isEqualTo(50.0);
    }
}
