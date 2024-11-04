package lotto;

import lotto.util.ProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

  @DisplayName("총 투자 금액과 당첨 금액을 통해 수익률을 계산한다.")
  @Test
  void 수익률_계산() {
    int totalInvestment = 5000;
    int totalEarnings = 2500;

    double profitRate = ProfitCalculator.calculateProfitRate(totalInvestment, totalEarnings);
    assertThat(profitRate).isEqualTo(50.0);
  }
}
