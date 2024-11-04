package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("6개 일치하는 경우 1등")
    @Test
    void 여섯_개_일치하면_1등() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 일치, 보너스 볼 일치하는 경우 2등")
    @Test
    void 다섯_개_일치_보너스_볼_일치하면_2등() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 일치, 보너스 볼 불일치하는 경우 3등")
    @Test
    void 다섯_개_일치_보너스_볼_불일치하면_3등() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 일치하는 경우 4등")
    @Test
    void 네_개_일치하면_4등() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 일치하는 경우 5등")
    @Test
    void 세_개_일치하면_5등() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하 일치하는 경우 미당첨")
    @Test
    void 두_개_이하_일치하면_미당첨() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
