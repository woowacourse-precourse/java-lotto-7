package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @DisplayName("로또 티켓 결과를 계산하고 올바른 등수를 반환한다")
    @Test
    void 로또결과계산_정상작동() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등 (5개 + 보너스 번호)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 3등 (5개)
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),  // 4등 (4개)
                new Lotto(List.of(1, 2, 3, 20, 21, 22))  // 5등 (3개)
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResultCalculator calculator = new LottoResultCalculator(userLottos, winningNumbers, bonusNumber);
        List<LottoResult> results = calculator.calculateResults();

        assertThat(results.get(0).getRank()).isEqualTo(Rank.FIRST);  // 1등
        assertThat(results.get(1).getRank()).isEqualTo(Rank.SECOND); // 2등
        assertThat(results.get(2).getRank()).isEqualTo(Rank.THIRD);  // 3등
        assertThat(results.get(3).getRank()).isEqualTo(Rank.FOURTH); // 4등
        assertThat(results.get(4).getRank()).isEqualTo(Rank.FIFTH);  // 5등
    }
}
