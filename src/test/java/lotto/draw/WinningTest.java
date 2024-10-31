package lotto.draw;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningTest {

    @Test
    void 등수_확인_테스트_3등() {
        Winning rank = Winning.getWinningRank(5,false);
        assertThat(rank).isEqualTo(Winning.THIRD);
    }

    @Test
    void 등수_확인_테스트_2등() {
        Winning rank = Winning.getWinningRank(5,true);
        assertThat(rank).isEqualTo(Winning.SECOND);
    }

    @Test
    void 등수_확인_테스트_꽝() {
        Winning rank = Winning.getWinningRank(2,false);
        assertThat(rank).isEqualTo(Winning.LOSING_TICKET);
    }

    @Test
    void 등수_확인_테스트_예외값_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> Winning.getWinningRank(2,true));
    }

}