package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    void 순위_계산_테스트() {
        assertThat(Rank.calculate(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.calculate(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.calculate(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.calculate(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.calculate(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.calculate(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.calculate(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.calculate(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.calculate(0, false)).isEqualTo(Rank.MISS);
    }
}
