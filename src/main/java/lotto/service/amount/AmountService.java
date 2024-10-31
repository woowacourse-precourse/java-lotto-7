package lotto.service.amount;

import lotto.command.validate.PurchaseAmountCommand;
import lotto.dto.PurchaseAmountUserInput;
import lotto.model.amount.PurchaseAmount;

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

  public int getPurchasableCount (PurchaseAmount amount, int price) {
    return amount.calculatePurchasableCount(price);
  }
}
