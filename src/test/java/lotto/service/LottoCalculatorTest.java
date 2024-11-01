package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

  @DisplayName("구매 금액에 따른 티켓 수를 정확히 계산한다")
  @Test
  void 구매_금액에_따른_티켓_수를_정확히_계산한다() {
    LottoCalculator calculator = new LottoCalculator();
    int ticketCount = calculator.calculateNumberOfTickets(new BigDecimal("8000"));
    assertEquals(8, ticketCount);
  }

  @DisplayName("총 당첨금과 구매 금액에 따른 수익률을 정확히 계산한다")
  @Test
  void 총_당첨금과_구매_금액에_따른_수익률을_정확히_계산한다() {
    LottoCalculator calculator = new LottoCalculator();
    BigDecimal profitRate = calculator.calculateProfitRate(5000L, new BigDecimal("8000"));
    assertEquals(new BigDecimal("62.5"), profitRate);
  }

  @DisplayName("유효한 구입 금액으로 티켓 수를 계산한다")
  @Test
  void 유효한_구입_금액으로_티켓_수를_계산한다() {
    LottoCalculator calculator = new LottoCalculator();
    BigDecimal purchaseAmount = new BigDecimal("8000");
    int ticketCount = calculator.calculateNumberOfTickets(purchaseAmount);
    assertEquals(8, ticketCount);
  }
}
