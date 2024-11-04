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
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 12, 13, 14))
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
}
