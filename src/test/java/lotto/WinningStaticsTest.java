package lotto;

import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.WinningStatics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class WinningStaticsTest {

    @Test
    @DisplayName("당첨번호 3개를 맞출시 당첨통계의 FIRST가 1증가")
    void getFirstWinningCountTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6,","7");
        WinningStatics winningStatics = new WinningStatics();

        winningStatics.numOfWinnings(List.of(List.of(1,2,3,7,8,9)), winningNumber);
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();

        assertThat(statics.get(WinningRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호 4개를 맞출시 당첨통계의 SECOND가 1증가")
    void getSecondWinningCountTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6,","7");
        WinningStatics winningStatics = new WinningStatics();

        winningStatics.numOfWinnings(List.of(List.of(1,2,3,4,8,9)), winningNumber);
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();

        assertThat(statics.get(WinningRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호 5개를 맞추고 보너스 번호는 못맞출 때 당첨통계의 THIRD가 1증가")
    void getThirdWinningCountTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6,","7");
        WinningStatics winningStatics = new WinningStatics();

        winningStatics.numOfWinnings(List.of(List.of(1,2,3,4,5,9)), winningNumber);
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();

        assertThat(statics.get(WinningRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호 5개를 맞추고 보너스 번호를 맞출 때 당첨통계의 FOURTH가 1증가")
    void getFourthWinningCountTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6,","9");
        WinningStatics winningStatics = new WinningStatics();

        winningStatics.numOfWinnings(List.of(List.of(1,2,3,4,5,9)), winningNumber);
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();

        assertThat(statics.get(WinningRank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호 6개를 맞출시 당첨통계의 FIFTH가 1증가")
    void getFifthWinningCountTest() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6,","7");
        WinningStatics winningStatics = new WinningStatics();

        winningStatics.numOfWinnings(List.of(List.of(1,2,3,4,5,6)), winningNumber);
        Map<WinningRank, Integer> statics = winningStatics.getWinningStatics();

        assertThat(statics.get(WinningRank.FIFTH)).isEqualTo(1);
    }
}
