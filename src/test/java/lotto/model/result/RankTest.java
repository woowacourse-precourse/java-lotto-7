package lotto.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("일치 개수와 보너스 일치 여부로 Rank를 찾는다.")
    @Test
    void 일치_개수와_보너스_일치_여부로_Rank_찾기() {
        assertThat(Rank.findRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.findRank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.findRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("일치 개수로 SECOND 후보를 확인한다.")
    @Test
    void Rank_SECOND_후보_확인() {
        assertThat(Rank.hasCountToBeSecond(5)).isTrue();
        assertThat(Rank.hasCountToBeSecond(4)).isFalse();
    }

    @DisplayName("Rank 목록을 상금순으로 정렬하여 반환한다.")
    @Test
    void Rank_상금순으로_정렬() {
        assertThat(Rank.sortedRanksExceptNone()).containsExactly(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND,
                Rank.FIRST);
    }
}
