package lotto.domain.rank.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RevenueRateTest {
    @Test
    @DisplayName("주어진 수익과 지출로 올바른 수익률을 계산할 수 있다.")
    void 주어진_수익과_지출로_올바른_수익률을_계산할_수_있다() {
        // given
        final int revenue = 5000;
        final int cost = 8000;

        // when
        RevenueRate rate = RevenueRate.of(revenue, cost);

        // then
        assertThat(rate.toString()).isEqualTo("62.5%");
    }

    @Test
    @DisplayName("첫 째짜리까지 반올림해서 표현할 수 있다.")
    void 첫째_자리까지_반올림하여_나타낼_수_있다() {
        // given
        final int revenue = 4000;
        final int cost = 7000;

        // when
        RevenueRate rate = RevenueRate.of(revenue, cost);

        // then
        assertThat(rate.toString()).isEqualTo("57.1%");
    }
}