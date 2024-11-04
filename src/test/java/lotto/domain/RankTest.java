package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 당첨_순위를_판단한다() {
        // when & then
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(0, false)).isEqualTo(Rank.NONE);
    }

    @Test
    void 당첨_순위의_상금을_가져온다() {
        // when & then
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
    }

    @Test
    void 당첨_순위의_개수를_가져온다() {
        // when & then
        assertThat(Rank.FIFTH.getMatch()).isEqualTo(3);
        assertThat(Rank.FOURTH.getMatch()).isEqualTo(4);
        assertThat(Rank.THIRD.getMatch()).isEqualTo(5);
        assertThat(Rank.SECOND.getMatch()).isEqualTo(5);
        assertThat(Rank.FIRST.getMatch()).isEqualTo(6);
    }
}
