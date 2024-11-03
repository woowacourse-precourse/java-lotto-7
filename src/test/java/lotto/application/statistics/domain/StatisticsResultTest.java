package lotto.application.statistics.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StatisticsResult - 통계 결과")
class StatisticsResultTest {

    @Test
    @DisplayName("당첨 등수별 개수 조회")
    void 당첨_등수별_개수_조회() {
        // given
        RankCounter counter = new RankCounter();
        counter.add(Rank.FIRST);
        counter.add(Rank.THIRD);
        counter.add(Rank.THIRD);
        StatisticsResult result = StatisticsResult.from(counter);

        // expect
        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(Rank.THIRD)).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        // given
        RankCounter counter = new RankCounter();
        counter.add(Rank.FIFTH);  // 5000원
        StatisticsResult result = StatisticsResult.from(counter);

        // when
        double profitRate = result.calculateProfitRate(8000);

        // then
        assertThat(profitRate).isEqualTo(62.5);  // (5,000 / 8,000)* 100
    }

}
