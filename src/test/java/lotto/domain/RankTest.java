package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    private static final int MATCH_COUNT_SIX = 6;
    private static final int MATCH_COUNT_FIVE = 5;
    private static final int MATCH_COUNT_FOUR = 4;
    private static final int MATCH_COUNT_THREE = 3;
    private static final int MATCH_COUNT_TWO = 2;
    private static final int MATCH_COUNT_ONE = 1;
    private static final int MATCH_COUNT_ZERO = 0;
    private static final boolean BONUS_MATCH_SUCCESS = true;
    private static final boolean BONUS_MATCH_FAILED = false;

    @DisplayName("로또 번호 일치 개수와 보너스 일치 여부에 따라 올바른 등수가 매칭되는지 확인")
    @Test
    void 일치_개수와_보너스_일치_여부로_등수_확인() {
        assertThat(Rank.valueOf(MATCH_COUNT_SIX, BONUS_MATCH_FAILED)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(MATCH_COUNT_FIVE, BONUS_MATCH_SUCCESS)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(MATCH_COUNT_FIVE, BONUS_MATCH_FAILED)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(MATCH_COUNT_FOUR, BONUS_MATCH_FAILED)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(MATCH_COUNT_THREE, BONUS_MATCH_FAILED)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(MATCH_COUNT_TWO, BONUS_MATCH_FAILED)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(MATCH_COUNT_ONE, BONUS_MATCH_FAILED)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(MATCH_COUNT_ZERO, BONUS_MATCH_FAILED)).isEqualTo(Rank.NONE);
    }
}
