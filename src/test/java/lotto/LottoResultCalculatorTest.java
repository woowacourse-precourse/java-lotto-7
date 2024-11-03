package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    @Test
    @DisplayName("구매한 로또가 1등 조건을 만족할 때 1등으로 판정된다")
    void 구매한_로또가_1등() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<PrizeRank, Integer> resultCounts = LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(resultCounts.get(PrizeRank.FIRST)).isEqualTo(1);
        assertThat(resultCounts.get(PrizeRank.SECOND)).isEqualTo(0);
    }

    @Test
    @DisplayName("구매한 로또가 2등 조건을 만족할 때 2등으로 판정된다")
    void 구매한_로또가_2등() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 5개 일치 + 보너스 번호
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<PrizeRank, Integer> resultCounts = LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(resultCounts.get(PrizeRank.SECOND)).isEqualTo(1);
        assertThat(resultCounts.get(PrizeRank.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("구매한 로또가 3등 조건을 만족할 때 3등으로 판정된다")
    void 구매한_로또가_3등() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 5개 일치, 보너스 번호 불일치
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<PrizeRank, Integer> resultCounts = LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(resultCounts.get(PrizeRank.THIRD)).isEqualTo(1);
        assertThat(resultCounts.get(PrizeRank.SECOND)).isEqualTo(0);
    }

    @Test
    @DisplayName("구매한 로또가 4등 조건을 만족할 때 4등으로 판정된다")
    void 구매한_로또가_4등() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 8, 9))); // 4개 일치
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<PrizeRank, Integer> resultCounts = LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(resultCounts.get(PrizeRank.FOURTH)).isEqualTo(1);
        assertThat(resultCounts.get(PrizeRank.THIRD)).isEqualTo(0);
    }

    @Test
    @DisplayName("구매한 로또가 5등 조건을 만족할 때 5등으로 판정된다")
    void 구매한_로또가_5등() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9))); // 3개 일치
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<PrizeRank, Integer> resultCounts = LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(resultCounts.get(PrizeRank.FIFTH)).isEqualTo(1);
        assertThat(resultCounts.get(PrizeRank.FOURTH)).isEqualTo(0);
    }
}
