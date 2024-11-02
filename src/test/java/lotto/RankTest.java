package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void 당첨등수_확인_성공() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRank(2, false)).isEqualTo(Rank.NONE);
    }
}
