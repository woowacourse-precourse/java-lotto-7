package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultCalculatorTest {
    @DisplayName("로또 결과를 모두 반환한다. - 1등,2등")
    @Test
    void calculateResults() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        WinningResultCalculator resultCalculator = new WinningResultCalculator();

        // when
        List<LottoResult> lottoResults = resultCalculator.calculateResults(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(lottoResults).hasSize(2);
        assertThat(lottoResults.get(0).getRank()).isEqualTo(Rank.FIRST);
        assertThat(lottoResults.get(1).getRank()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("총 당첨 금액을 계산한다")
    @Test
    void calculateTotalWinnings() {
        // given
        List<LottoResult> results = new ArrayList<>();
        results.add(new LottoResult(Rank.FIRST));
        results.add(new LottoResult(Rank.SECOND));

        WinningResultCalculator resultCalculator = new WinningResultCalculator();

        // when
        int totalWinnings = resultCalculator.calculateTotalWinnings(results);

        // then
        assertThat(totalWinnings).isEqualTo(Rank.FIRST.getWinnings() + Rank.SECOND.getWinnings());
    }

}