package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("6개 번호가 일치하면 1등을 반환한다.")
    @Test
    void 여섯_개_번호_일치() {
        // given
        Rank rank = Rank.findRank(6, false);
        // when & then
        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void 다섯_개_번호_및_보너스_일치() {
        // given
        Rank rank = Rank.findRank(5, true);
        // when & then
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 불일치하면 3등을 반환한다.")
    @Test
    void 다섯_개_번호_일치() {
        // given
        Rank rank = Rank.findRank(5, false);
        // when & then
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1_500_000);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다.")
    @Test
    void 네_개_번호_일치() {
        // given
        Rank rank = Rank.findRank(4, false);
        // when & then
        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getPrize()).isEqualTo(50_000);
    }

    @DisplayName("3개 번호가 일치하면 5등을 반환한다.")
    @Test
    void 세_개_번호_일치() {
        // given
        Rank rank = Rank.findRank(3, false);
        // when & then
        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5_000);
    }

    @DisplayName("2개 이하의 번호가 일치하면 당첨되지 않음(NONE)을 반환한다.")
    @Test
    void 두_개_이하_번호_일치() {
        // given
        Rank rank = Rank.findRank(2, false);
        // when & then
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getPrize()).isEqualTo(0);
    }
}
