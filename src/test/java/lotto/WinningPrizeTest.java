package lotto;

import java.util.Optional;
import lotto.domain.WinningPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningPrizeTest {

    @Test
    void 당첨_1등_테스트() {
        //given
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(6, false);
        //when
        WinningPrize expectWinningPrize = WinningPrize.FIRST;
        //then
        Assertions.assertThat(winningPrize.get()).isEqualTo(expectWinningPrize);
    }

    @Test
    void 당첨_2등_테스트() {
        //given
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(5, true);
        //when
        WinningPrize expectWinningPrize = WinningPrize.SECOND;
        //then
        Assertions.assertThat(winningPrize.get()).isEqualTo(expectWinningPrize);
    }

    @Test
    void 당첨_3등_테스트() {
        //given
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(5, false);
        //when
        WinningPrize expectWinningPrize = WinningPrize.THIRD;
        //then
        Assertions.assertThat(winningPrize.get()).isEqualTo(expectWinningPrize);
    }

    @Test
    void 당첨_4등_테스트() {
        //given
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(4, false);
        //when
        WinningPrize expectWinningPrize = WinningPrize.FOURTH;
        //then
        Assertions.assertThat(winningPrize.get()).isEqualTo(expectWinningPrize);
    }

    @Test
    void 당첨_5등_테스트() {
        //given
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(3, false);
        //when
        WinningPrize expectWinningPrize = WinningPrize.FIFTH;
        //then
        Assertions.assertThat(winningPrize.get()).isEqualTo(expectWinningPrize);
    }

    @Test
    void 당첨_실패_테스트() {
        //given
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(2, false);
        //when, then
        Assertions.assertThat(winningPrize.isEmpty()).isEqualTo(true);
    }
}