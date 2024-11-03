package lotto.application.statistics.domain;


import static lotto.application.statistics.domain.Rank.FIFTH;
import static lotto.application.statistics.domain.Rank.FIRST;
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

}
