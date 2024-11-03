package lotto.application.statistics.domain;


import static lotto.application.statistics.domain.Rank.FIFTH;
import static lotto.application.statistics.domain.Rank.FIRST;
import static lotto.application.statistics.domain.Rank.FOURTH;
import static lotto.application.statistics.domain.Rank.NONE;
import static lotto.application.statistics.domain.Rank.SECOND;
import static lotto.application.statistics.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RankCounter - 등수 카운터")
class RankCounterTest {

    @DisplayName("생성 시 모든 등수의 카운터가 0으로 초기화됨")
    @Test
    void 생성시_모든등수의_카운터가_0으로_초기화됨() {

        // given
        RankCounter counter = new RankCounter();

        // then
        assertAll(
                () -> assertThat(counter.getCount(FIRST)).isZero(),
                () -> assertThat(counter.getCount(SECOND)).isZero(),
                () -> assertThat(counter.getCount(THIRD)).isZero(),
                () -> assertThat(counter.getCount(FIFTH)).isZero(),
                () -> assertThat(counter.getCount(NONE)).isZero()
        );
    }

    @DisplayName("등수 추가하면 해당 등수 카운터 증가")
    @Test
    void 등수_추가하면_해당등수_카운터_증가() {
        // given
        RankCounter counter = new RankCounter();

        // when
        counter.add(FIRST);
        counter.add(FIRST);
        counter.add(SECOND);

        // then
        assertAll(
                () -> assertThat(counter.getCount(FIRST)).isEqualTo(2),
                () -> assertThat(counter.getCount(SECOND)).isEqualTo(1)
        );
    }

    @DisplayName("총 상금 정확하게 계산함")
    @Test
    void 총_상금_정확하게_계산함() {
        // given
        RankCounter counter = new RankCounter();
        counter.add(FIRST);
        counter.add(SECOND);
        counter.add(THIRD);
        counter.add(FOURTH);
        counter.add(FIFTH);
        counter.add(NONE);

        // when
        int totalPrice = counter.calculateTotalPrize();

        // then
        int expect = 2000000000 + 30000000 + 1500000 + 50000 + 5000 + 0;
        assertThat(totalPrice).isEqualTo(expect);
    }

}
