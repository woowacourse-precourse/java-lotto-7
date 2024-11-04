package lotto.service.amount;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.command.view.validate.PurchaseAmountCommand;
import lotto.container.DependencyInjectionContainer;
import lotto.dto.BonusUserInput;
import lotto.dto.MatchResults;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.model.amount.ProfitAmount;
import lotto.model.amount.ProfitRate;
import lotto.model.amount.PurchaseAmount;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PurchasedLottos;
import lotto.model.lotto.WinningLotto;
import lotto.service.lotto.LottoService;
import lotto.service.lotto.constant.LottoConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 3.
 */
class AmountServiceTest {
  private AmountService amountService;
  private MatchResults mockResults;

  @BeforeEach
  void setUp(){
    DependencyInjectionContainer container = new DependencyInjectionContainer();
    amountService = container.get(AmountService.class);

    List<Integer> winningLottoNumbers = List.of(1,2,3,4,5,6);
    int bonusNumber = 7;

    WinningLotto winningLotto = WinningLotto.from(
        WinningLottoUserInput.from(winningLottoNumbers));
    winningLotto.addBonus(
        BonusUserInput.from(bonusNumber));

    PurchasedLottos purchasedLottos = PurchasedLottos.from(List.of(
        Lotto.from(List.of(1, 2, 3, 4, 5, 6)),  // 1등, 6개 번호 일치
        Lotto.from(List.of(1, 2, 3, 4, 5, 7)),  // 2등, 5개 번호 & 보너스 번호 일치
        Lotto.from(List.of(1, 2, 3, 4, 5, 8))   // 3등, 5개 번호 일치
    ));

    LottoService lottoService = container.get(LottoService.class);
    mockResults = lottoService.matchWinningLotto(winningLotto, purchasedLottos);
  }

  @Test
  @DisplayName("[success]getValidateCommand : 객체 반환 확인")
  void getValidateCommand_shouldReturnCorrectCommand() {
    assertThat(amountService.getValidateCommand())
        .isNotNull()
        .isInstanceOf(PurchaseAmountCommand.class);
  }

  @Test
  @DisplayName("[success]createPurchaseAmount : 유효한 객체 생성")
  void createPurchaseAmount_shouldReturnCorrectPurchaseAmount() {
    long amount = 7000;
    PurchaseAmountUserInput userInput = PurchaseAmountUserInput.from(amount);

    PurchaseAmount purchaseAmount = amountService.createPurchaseAmount(userInput);
    assertThat(purchaseAmount.getAmount())
        .isNotNull()
        .isEqualTo(amount);
  }

  @ParameterizedTest
  @CsvSource({
      "8000, 1000, 8",
      "10000, 1000, 10",
      "15000, 1500, 10"
  })
  @DisplayName("[success]getPurchasableCount : 구매 금액에 따른 구매 가능한 로또 갯수 반환")
  void getPurchasableCount_shouldReturnCorrectCount(long amount, int price, long expectedCount) {
    PurchaseAmount purchaseAmount = PurchaseAmount.from(
        PurchaseAmountUserInput.from(amount));

    long actualCount = amountService.getPurchasableCount(purchaseAmount, price);

    assertThat(actualCount).isEqualTo(expectedCount);
  }

  @Test
  @DisplayName("[success]calculateProfitAmount : 당첨 금액 반환")
  void calculateProfitAmount_shouldReturnCorrectAmount() {
    long expected = LottoConstant.MATCH_SIX_PRIZE +
        LottoConstant.MATCH_FIVE_BONUS_PRIZE +
        LottoConstant.MATCH_FIVE_PRIZE;
    ProfitAmount profitAmount = amountService.calculateProfitAmount(mockResults);
    assertThat(profitAmount.getAmount())
        .isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({
      "8000, 5000, 62.5",
      "10000, 20000, 200.0",
      "15000, 7500, 50.0",
      "1000, 0, 0.0",
      "100000, 200000, 200.0"
  })
  @DisplayName("[success]calculateProfitRate : 수익률 계산")
  void calculateProfitRate_shouldReturnCorrectRate(long purchase, long profit, double expectedRate) {
    PurchaseAmount purchaseAmount = PurchaseAmount.from(
        PurchaseAmountUserInput.from(purchase)
    );
    ProfitAmount profitAmount = ProfitAmount.from(profit);

    ProfitRate profitRate = amountService.calculateProfitRate(purchaseAmount, profitAmount);

    assertThat(profitRate.getRate()).isEqualTo(BigDecimal.valueOf(expectedRate));
  }

  @ParameterizedTest
  @CsvSource({
      "1000000000, 2000000000, 200.0",  // 10억 구매, 20억 수익
      "2000000000, 3000000000, 150.0",  // 20억 구매, 30억 수익
      "5000000000, 4000000000, 80.0",   // 50억 구매, 40억 수익
      "1000000000, 500000000, 50.0",    // 10억 구매, 5억 수익
      "9999999999, 9999999999, 100.0"   // 약 100억 구매, 약 100억 수익
  })
  @DisplayName("[success]calculateProfitRate : 수익률 계산 - 큰 숫자")
  void calculateProfitRate_shouldReturnCorrectRateWithBigNumbers(long purchase, long profit, double expectedRate) {
    PurchaseAmount purchaseAmount = PurchaseAmount.from(
        PurchaseAmountUserInput.from(purchase)
    );
    ProfitAmount profitAmount = ProfitAmount.from(profit);

    ProfitRate profitRate = amountService.calculateProfitRate(purchaseAmount, profitAmount);

    assertThat(profitRate.getRate()).isEqualTo(BigDecimal.valueOf(expectedRate));
  }
}