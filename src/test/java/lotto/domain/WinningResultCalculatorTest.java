package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultCalculatorTest {

    private static final List<Lotto> lottos = createSampleLottos();
    private static final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private static final int bonusNumber = 7;

    private static List<Lotto> createSampleLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        return lottos;
    }

    @DisplayName("로또 결과를 모두 반환한다. - 1등,2등")
    @Test
    void calculateResults() {
        // given
        WinningResultCalculator resultCalculator = WinningResultCalculator.from(lottos, winningNumbers, bonusNumber);

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
        WinningResultCalculator resultCalculator = WinningResultCalculator.from(lottos, winningNumbers, bonusNumber);

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
        WinningResultCalculator resultCalculator = WinningResultCalculator.from(lottos, winningNumbers, bonusNumber);

        // when
        double profitRate = resultCalculator.calculateProfitRate(purchaseAmount);

        // then
        double expectedProfitRate = ProfitCalculator.calculateProfitRate(
                Rank.FIRST.getWinnings() + Rank.SECOND.getWinnings(),
                purchaseAmount
        );
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

}