package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WinningResultCalculatorTest {

    @Test
    @DisplayName("당첨 결과 계산 테스트")
    public void testCalculateResults() {
        WinningResultCalculator calculator = new WinningResultCalculator();
        List<Lotto> userLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(Arrays.asList(1, 2, 3, 12, 13, 14)) // 5등
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> results = calculator.calculateResults(userLottos, winningNumbers, bonusNumber);

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    public void testCalculateProfitRate() {
        WinningResultCalculator calculator = new WinningResultCalculator();
        Map<Rank, Integer> results = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.NONE, 0
        );

        double profitRate = calculator.calculateProfitRate(results, 8000);
        assertThat(profitRate).isEqualTo(25000000.0);
    }
}
