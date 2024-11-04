package lotto.model;

import lotto.constant.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("당첨 번호 개수와 보너스 번호 일치 여부에 따른 순위 결정")
    @Test
    void getRank_테스트() {
        // 1등 (6개 일치)
        Assertions.assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(Rank.getRank(6, true)).isEqualTo(Rank.FIRST);

        // 2등 (5개 + 보너스 일치)
        Assertions.assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);

        // 3등 (5개 일치)
        Assertions.assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);

        // 4등 (4개 일치)
        Assertions.assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(Rank.getRank(4, true)).isEqualTo(Rank.FOURTH);

        // 5등 (3개 일치)
        Assertions.assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(Rank.getRank(3, true)).isEqualTo(Rank.FIFTH);

        // 미당첨 (2개 이하 일치)
        Assertions.assertThat(Rank.getRank(2, false)).isEqualTo(Rank.NONE);
        Assertions.assertThat(Rank.getRank(2, true)).isEqualTo(Rank.NONE);
        Assertions.assertThat(Rank.getRank(1, false)).isEqualTo(Rank.NONE);
        Assertions.assertThat(Rank.getRank(0, false)).isEqualTo(Rank.NONE);
    }
}
