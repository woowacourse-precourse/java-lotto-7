package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsCalculatorTest {

    Lottos lottos;
    Lotto winningNumbers;
    BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
        lottos.addLotto(() -> List.of(1, 2, 3, 4, 5, 6));

        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.createBonusNumber(winningNumbers.getNumbers(), "7");
    }

    @DisplayName("당첨 통계를 계산한다.")
    @Test
    void 당첨_통계_계산() {
        WinningStatistics winningStatistics =
                WinningStatisticsCalculator.calculateStatistics(lottos, winningNumbers, bonusNumber.getBonusNumber());

        assertThat(winningStatistics.getStatistics().get(WinningRank.FIRST)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률_계산() {
        WinningStatistics winningStatistics =
                WinningStatisticsCalculator.calculateStatistics(lottos, winningNumbers, bonusNumber.getBonusNumber());

        double returnRate = WinningStatisticsCalculator.calculateReturnRate(winningStatistics, 1000);

        assertThat(returnRate).isEqualTo(200000000);
    }

}