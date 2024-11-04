package lotto.winning;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 등수_확인_테스트_3등() {
        Rank rank = Rank.getWinningRank(5,false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 등수_확인_테스트_2등() {
        Rank rank = Rank.getWinningRank(5,true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 등수_확인_테스트_꽝() {
        Rank rank = Rank.getWinningRank(2,false);
        assertThat(rank).isEqualTo(Rank.LOSING_TICKET);
    }

    @Test
    void 등수_확인_테스트_예외값_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> Rank.getWinningRank(2,true));
    }

}