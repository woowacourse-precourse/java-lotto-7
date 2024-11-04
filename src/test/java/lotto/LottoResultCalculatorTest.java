package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @DisplayName("로또 티켓 결과를 계산하고 올바른 등수를 집계한다")
    @Test
    void 로또결과계산_정상작동() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),    // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),    // 2등 (5개 + 보너스 번호)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),    // 3등 (5개)
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),  // 4등 (4개)
                new Lotto(List.of(1, 2, 3, 20, 21, 22))  // 5등 (3개)
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResultCalculator calculator = new LottoResultCalculator(userLottos, winningNumbers, bonusNumber);
        Map<Rank, Integer> statistics = calculator.calculateStatistics();

        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);    // 1등 1개
        assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);   // 2등 1개
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(1);    // 3등 1개
        assertThat(statistics.get(Rank.FOURTH)).isEqualTo(1);   // 4등 1개
        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(1);    // 5등 1개
        assertThat(statistics.get(Rank.NONE)).isEqualTo(0);     // 당첨되지 않은 티켓 없음
    }
}
