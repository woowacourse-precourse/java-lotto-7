package lotto;

import lotto.domain.calculator.WinningCalculator;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningStatistics;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCalculatorTest {

    @DisplayName("당첨 통계를 계산한다")
    @Test
    void calculateWinningStatistics() {
        WinningCalculator calculator = new WinningCalculator();
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8))   // 3등
        );
        Lottos lottos = new Lottos(lottoList);

        WinningStatistics statistics = calculator.calculate(lottos, winningLotto);

        assertThat(statistics.getWinningCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(statistics.getWinningCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(statistics.getWinningCount(LottoRank.THIRD)).isEqualTo(1);
    }
}