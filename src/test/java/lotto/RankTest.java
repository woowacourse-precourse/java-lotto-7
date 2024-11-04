package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.Rank;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void 세개_맞으면_5등이다() {
        int matchCount = 3;
        boolean hasBonusNumber = false;

        assertThat(Rank.of(matchCount, hasBonusNumber)).isEqualTo(Rank.FIFTH);
    }


    @Test
    void 네개_맞으면_4등이다() {
        int matchCount = 4;
        boolean hasBonusNumber = false;

        assertThat(Rank.of(matchCount, hasBonusNumber)).isEqualTo(Rank.FOURTH);
    }


    @Test
    void 보너스_없이_5개를_맞으면_3등이다() {
        int matchCount = 5;
        boolean hasBonusNumber = false;

        assertThat(Rank.of(matchCount, hasBonusNumber)).isEqualTo(Rank.THIRD);
    }


    @Test
    void 보너스에_더해_5개를_맞으면_2등이다() {
        int matchCount = 5;
        boolean hasBonusNumber = true;

        assertThat(Rank.of(matchCount, hasBonusNumber)).isEqualTo(Rank.SECOND);
    }


    @Test
    void 여섯개를_맞으면_1등이다() {
        int matchCount = 6;
        boolean hasBonusNumber = false;

        assertThat(Rank.of(matchCount, hasBonusNumber)).isEqualTo(Rank.FIRST);
    }
}
