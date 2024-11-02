package lotto;

import lotto.domain.earning.Earning;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.WinningStatics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class EarningTest {

    @Test
    @DisplayName("구입 금액 8000원, 5000원 당첨")
    void EarningFirstTest() {
        WinningStatics winningStatics = new WinningStatics();
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();
        statics.put(WinningRank.FIRST,1);

        Earning earning = new Earning(8000, statics);

        assertThat(earning.getEarning()).isEqualTo(62.5);
    }

    @Test
    @DisplayName("구입 금액 10000원, 50000원 당첨")
    void EarningSecondTest() {
        WinningStatics winningStatics = new WinningStatics();
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();
        statics.put(WinningRank.SECOND,1);

        Earning earning = new Earning(10000, statics);

        assertThat(earning.getEarning()).isEqualTo(500);
    }

    @Test
    @DisplayName("구입 금액 50000원, 31500000원 당첨")
    void EarningThirdAndFourthTest() {
        WinningStatics winningStatics = new WinningStatics();
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();
        statics.put(WinningRank.THIRD,1);
        statics.put(WinningRank.FOURTH,1);

        Earning earning = new Earning(50000, statics);

        assertThat(earning.getEarning()).isEqualTo(63000);
    }
}
