package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("적절한 랭크가 있는 경우")
    void returnIfValidRankExist() {
        // given
        Rank rank = Rank.rank(6, true);

        // when & then
        assertThat(rank).isNotNull();
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등과 3등 구분이 잘 된다")
    void testSecondAndThirdRank() {
        // given
        Rank second = Rank.rank(5, true);
        Rank third = Rank.rank(5, false);

        // when & then
        assertThat(second).isEqualTo(Rank.SECOND);
        assertThat(second).isNotEqualTo(Rank.THIRD);
        assertThat(third).isEqualTo(Rank.THIRD);
        assertThat(third).isNotEqualTo(Rank.SECOND);
    }
}
