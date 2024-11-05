package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @Test
    @DisplayName("Statistics에 Rank 추가 시 올바르게 카운트되는지 테스트")
    void success_addRank() {
        // given
        Statistics statistics = new Statistics();
        Rank rank = Rank.FIFTH;

        // when
        statistics.addRank(rank);

        // then
        assertThat(statistics.getRankCountMap().get(rank)).isEqualTo(1);
    }

    @Test
    @DisplayName("Statistics 수익률 계산 테스트 - 정상적인 투자 대비 당첨 금액")
    void success_calculateYield() {
        // given
        Statistics statistics = new Statistics();
        statistics.addRank(Rank.FIFTH); // 5,000원
        statistics.addRank(Rank.FIRST); // 2,000,000,000원
        long totalPrize = Rank.FIFTH.getPrize() + Rank.FIRST.getPrize();
        long totalInvestment = 3 * 1000; // 예: 3장의 로또를 구매했다고 가정

        // when
        double yield = statistics.calculateYield(totalPrize, totalInvestment);

        // then
        assertThat(yield).isEqualTo((double)(5_000 + 2_000_000_000) / 3_000 * 100);
    }

    @Test
    @DisplayName("Statistics 수익률 계산 테스트 - 투자 금액이 0일 때")
    void success_calculateYield_zeroInvestment() {
        // given
        Statistics statistics = new Statistics();
        long totalPrize = 1_000_000;
        long totalInvestment = 0;

        // when
        double yield = statistics.calculateYield(totalPrize, totalInvestment);

        // then
        assertThat(yield).isEqualTo(0.0);
    }
}
