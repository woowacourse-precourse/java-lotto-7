package lotto.application.statistics.domain;


import static lotto.application.statistics.domain.Rank.FIFTH;
import static lotto.application.statistics.domain.Rank.FIRST;
import static lotto.application.statistics.domain.Rank.THIRD;
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
        counter.add(FIRST);
        counter.add(THIRD);
        counter.add(THIRD);
        StatisticsResult result = StatisticsResult.from(counter);

        // expect
        assertThat(result.getCount(FIRST)).isEqualTo(1);
        assertThat(result.getCount(THIRD)).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        // given
        RankCounter counter = new RankCounter();
        counter.add(FIFTH);  // 5000원
        StatisticsResult result = StatisticsResult.from(counter);

        // when
        double profitRate = result.calculateProfitRate(8000);

        // then
        assertThat(profitRate).isEqualTo(62.5);  // (5,000 / 8,000)* 100
    }

    @Test
    @DisplayName("수익률 소수점 둘째자리 반올림")
    void 수익률_소수점_둘째자리_반올림() {
        // given
        RankCounter counter = new RankCounter();
        counter.add(FIFTH);
        StatisticsResult result = StatisticsResult.from(counter);

        // when
        double profitRate = result.calculateProfitRate(7000);

        // then
        assertThat(profitRate).isEqualTo(71.43);
    }

}
