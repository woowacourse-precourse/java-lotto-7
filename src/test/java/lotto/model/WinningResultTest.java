package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("해당 결과의 순위에 해당하는 당첨 개수를 확인한다.")
    @Test
    void getWinningCount() {
        //given
        WinningResult result = new WinningResult(Map.of(
            Rank.FIRST, 1,
            Rank.SECOND, 2,
            Rank.THIRD, 3,
            Rank.FOURTH, 4,
            Rank.FIFTH, 5,
            Rank.NONE, 6)
        );
        //when
        Integer winningCount = result.getWinningCount(Rank.FIRST);
        //then
        assertThat(winningCount).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        //given
        WinningResult result = new WinningResult(Map.of(
            Rank.FIRST, 0,
            Rank.SECOND, 0,
            Rank.THIRD, 0,
            Rank.FOURTH, 0,
            Rank.FIFTH, 1,
            Rank.NONE, 7)
        );
        //when
        double profitRate = result.getProfitRate();
        //then
        assertThat(profitRate).isEqualTo(62.5);
    }

}