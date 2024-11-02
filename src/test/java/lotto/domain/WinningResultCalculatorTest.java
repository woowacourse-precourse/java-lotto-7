package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultCalculatorTest {

    private static final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private static final int bonusNumber = 7;

    private static List<Lotto> createSampleLottos(List<List<Integer>> numbersList) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> numbers : numbersList) {
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    @DisplayName("로또 결과를 모두 반환한다. - 1등,2등")
    @Test
    void calculateResults() {
        // given
        List<Lotto> lottos = createSampleLottos(List.of(
                List.of(1, 2, 3, 4, 5, 6),  // 1등
                List.of(1, 2, 3, 4, 5, 7)   // 2등
        ));
        WinningResultCalculator resultCalculator = WinningResultCalculator.of(lottos, winningNumbers, bonusNumber);

        // when
        List<LottoResult> lottoResults = resultCalculator.getResults();
        // then
        assertThat(lottoResults).hasSize(2);
        assertThat(lottoResults.get(0).getRank()).isEqualTo(Rank.FIRST);
        assertThat(lottoResults.get(1).getRank()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("총 당첨 금액을 계산한다")
    @Test
    void calculateTotalWinnings() {

        // given
        List<Lotto> lottos = createSampleLottos(List.of(
                List.of(1, 2, 3, 4, 5, 6),  // 1등
                List.of(1, 2, 3, 4, 5, 7)   // 2등
        ));
        WinningResultCalculator resultCalculator = WinningResultCalculator.of(lottos, winningNumbers, bonusNumber);

        // when
        int totalWinnings = resultCalculator.calculateTotalWinnings();

        // then
        int expectedWinnings = Rank.FIRST.getWinnings() + Rank.SECOND.getWinnings();
        assertThat(totalWinnings).isEqualTo(expectedWinnings);
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void calculateProfitRate() {
        // given
        int purchaseAmount = 2000;
        List<Lotto> lottos = createSampleLottos(List.of(
                List.of(1, 2, 3, 4, 5, 6),  // 1등
                List.of(1, 2, 3, 4, 5, 7)   // 2등
        ));
        WinningResultCalculator resultCalculator = WinningResultCalculator.of(lottos, winningNumbers, bonusNumber);

        // when
        double profitRate = resultCalculator.calculateProfitRate(purchaseAmount);

        // then
        double expectedProfitRate = ProfitCalculator.calculateProfitRate(
                Rank.FIRST.getWinnings() + Rank.SECOND.getWinnings(),
                purchaseAmount
        );
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("일치하는 번호가 없는 경우 0원의 수익을 반환한다.")
    @Test
    void calculateTotalWinnings_noMatchingNumbers() {
        // given
        List<Lotto> sampleLottos = createSampleLottos(List.of(
                List.of(8, 9, 10, 11, 12, 13), // 0개 일치
                List.of(14, 15, 16, 17, 18, 19) // 0개 일치
        ));
        WinningResultCalculator resultCalculator = WinningResultCalculator.of(sampleLottos, winningNumbers, bonusNumber);

        // when
        int totalWinnings = resultCalculator.calculateTotalWinnings();

        // then
        assertThat(totalWinnings).isEqualTo(0);
    }

}