package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;
import lotto.domain.strategy.DefaultRankCalculationStrategy;
import lotto.domain.strategy.RankCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    private final LottoResultCalculator calculator = new LottoResultCalculator(
            new RankCalculator(new DefaultRankCalculationStrategy()));

    @DisplayName("로또 티켓 결과를 계산하고 올바른 등수를 집계한다")
    @Test
    void 로또결과계산_정상작동() {
        // Given: 로또 티켓과 당첨 번호, 보너스 번호가 주어졌을 때
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),    // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),    // 2등 (5개 + 보너스 번호)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),    // 3등 (5개)
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),  // 4등 (4개)
                new Lotto(List.of(1, 2, 3, 20, 21, 22))  // 5등 (3개)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When: 로또 결과를 계산할 때
        Map<Rank, Integer> statistics = calculator.calculateStatistics(userLottos, winningNumbers, bonusNumber);

        // Then: 올바른 등수별 당첨 개수가 집계된다
        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);    // 1등 1개
        assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);   // 2등 1개
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(1);    // 3등 1개
        assertThat(statistics.get(Rank.FOURTH)).isEqualTo(1);   // 4등 1개
        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(1);    // 5등 1개
        assertThat(statistics.get(Rank.NONE)).isEqualTo(0);     // 당첨되지 않은 티켓 없음
    }

    @DisplayName("총 상금을 계산한다")
    @Test
    void 총상금계산_정상작동() {
        // Given: 로또 티켓과 당첨 번호, 보너스 번호가 주어졌을 때
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),    // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),    // 2등 (5개 + 보너스 번호)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),    // 3등 (5개)
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),  // 4등 (4개)
                new Lotto(List.of(1, 2, 3, 20, 21, 22))  // 5등 (3개)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When: 총 상금을 계산할 때
        Map<Rank, Integer> statistics = calculator.calculateStatistics(userLottos, winningNumbers, bonusNumber);
        int totalPrize = calculator.calculateTotalPrize(statistics);

        // Then: 예상 총 상금과 계산된 총 상금이 일치한다
        int expectedTotalPrize = Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.THIRD.getPrize()
                + Rank.FOURTH.getPrize() + Rank.FIFTH.getPrize();
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void 수익률계산_정상작동() {
        // Given: 로또 티켓과 당첨 번호, 보너스 번호, 구입 금액이 주어졌을 때
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),    // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),    // 2등 (5개 + 보너스 번호)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),    // 3등 (5개)
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),  // 4등 (4개)
                new Lotto(List.of(1, 2, 3, 20, 21, 22))  // 5등 (3개)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int purchaseAmount = userLottos.size() * 1000;

        // When: 수익률을 계산할 때
        Map<Rank, Integer> statistics = calculator.calculateStatistics(userLottos, winningNumbers, bonusNumber);
        double roi = calculator.calculateROI(statistics, purchaseAmount);

        // Then: 예상 수익률과 계산된 수익률이 일치한다
        double totalPrize = calculator.calculateTotalPrize(statistics);
        double expectedROI = Math.round((totalPrize / purchaseAmount * 100) * 10) / 10.0;
        assertThat(roi).isEqualTo(expectedROI);
    }
}
