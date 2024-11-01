package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.constant.category.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankCounterTest {

    @Test
    @DisplayName("RankCounter 생성 시 모든 Rank의 초기 값이 0인지 확인")
    void create() {
        // given
        RankCounter rankCounter = RankCounter.create();

        // when & then
        for (Rank rank : Rank.values()) {
            assertThat(rankCounter.getRankCount(rank)).isEqualTo(0);
        }
    }
}