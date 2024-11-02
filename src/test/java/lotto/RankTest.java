package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("정확한 일치 개수와 보너스 여부에 따라 적절한 Rank가 반환된다.")
    @Test
    void getRank_테스트() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);

        assertThat(Rank.getRank(2, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRank(2, true)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRank(0, false)).isEqualTo(Rank.NONE);
    }

}
