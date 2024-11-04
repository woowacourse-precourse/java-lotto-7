package lotto;

import java.util.ArrayList;
import java.util.List;

public class InitialController {

  private List<Lotto> lottoPaper = new ArrayList<>();
  private LottoWinningNumbers lottoWinningNumbers;

  private PurchaseAmount purchaseAmount;

  private PrizeCounter prizeCounter;

  private Calculator calculator;

  private LottoGenerator lottoGenerator;

  private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

  public InitialController(
      LottoWinningNumbers lottoWinningNumbers,
      LottoGenerator lottoGenerator,
      Calculator calculator) {
    this.lottoGenerator = lottoGenerator;
    this.lottoWinningNumbers = lottoWinningNumbers;
    this.calculator = calculator;
    initialLottoPaper(initialPurchaseAmountInput().getPurchaseQuantity());
    initialWinningNumberInput();
    countAndPrintPrize();
    calculateAndPrintProfit();

  }

  public PurchaseAmount initialPurchaseAmountInput() {
    this.purchaseAmount = new PurchaseAmount();
    return this.purchaseAmount;
  }

  public void initialWinningNumberInput() {
    lottoWinningNumbers.assignWinningNumber();
    lottoWinningNumbers.assignBonusNumber();
  }

  public void initialLottoPaper(int purchaseQuantity) {
    this.lottoPaper = lottoGenerator.generateLotto(purchaseQuantity);
    lottoGenerator.printLotto(this.lottoPaper);
  }

  public void countAndPrintPrize() {
    prizeCounter = calculator.calculatePrizes(lottoPaper, lottoWinningNumbers);
    prizeCounter.printPrizeCount();
  }

  public void calculateAndPrintProfit() {
    float result = calculator.CalculateProfit(this.purchaseAmount, this.prizeCounter);
    System.out.println(String.format(PROFIT_MESSAGE, result));
  }

}
