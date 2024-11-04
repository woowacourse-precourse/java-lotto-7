package lotto.service.amount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.command.view.validate.PurchaseAmountCommand;
import lotto.dto.MatchResults;
import lotto.dto.PurchaseAmountUserInput;
import lotto.model.amount.PurchaseAmount;
import lotto.model.amount.ProfitAmount;
import lotto.model.amount.ProfitRate;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class AmountService {
  private final PurchaseAmountCommand validateCommand;

  public AmountService(PurchaseAmountCommand inputCommand) {
    this.validateCommand = inputCommand;
  }

  public PurchaseAmountCommand getValidateCommand () {
    return this.validateCommand;
  }

  public PurchaseAmount createPurchaseAmount(PurchaseAmountUserInput userInput) {
    return PurchaseAmount.from(userInput);
  }

  public long getPurchasableCount (PurchaseAmount amount, int price) {
    return amount.calculatePurchasableCount(price);
  }

  public ProfitRate calculateProfitRate (PurchaseAmount purchaseAmount, MatchResults matchResults) {
    ProfitAmount profitAmount = calculateProfit(matchResults);
    BigDecimal profitRate = BigDecimal.valueOf(profitAmount.getAmount())
        .divide(BigDecimal.valueOf(purchaseAmount.getAmount()), 4,
            RoundingMode.HALF_UP)
        .multiply(BigDecimal.valueOf(100))
        .setScale(1, RoundingMode.HALF_UP);
    return ProfitRate.from(profitRate);
  }

  private ProfitAmount calculateProfit(MatchResults matchResults) {
    return ProfitAmount.from(matchResults.getTotalPrizeAmount());
  }

}
