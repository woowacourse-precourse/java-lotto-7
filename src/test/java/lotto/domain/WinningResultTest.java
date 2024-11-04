package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @Test
    void 초기화_테스트() {
        WinningResult winningResult = new WinningResult();

        Map<Rank, Integer> result = winningResult.getResult();
        assertThat(result).isNotEmpty();
        assertThat(result.values()).allMatch(count -> count == 0);
    }

    @Test
    void 결과_추가_테스트() {
        WinningResult winningResult = new WinningResult();
        winningResult.add(Rank.FIRST);
        winningResult.add(Rank.SECOND);
        winningResult.add(Rank.MISS);

        Map<Rank, Integer> result = winningResult.getResult();
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.MISS)).isNull();
    }

    @Test
    void 수익률_계산_테스트() {
        WinningResult winningResult = new WinningResult();
        winningResult.add(Rank.FIRST);
        winningResult.add(Rank.SECOND);

        int purchaseAmount = 100_000_000;
        double profit = winningResult.getProfit(purchaseAmount);

        double expectedProfit = (Rank.FIRST.getPrize() + Rank.SECOND.getPrize()) / (double) purchaseAmount * 100;
        expectedProfit = Math.round(expectedProfit * 100) / 100.0;

        assertThat(profit).isEqualTo(expectedProfit);
    }
}
