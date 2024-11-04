package lotto.model.amount;

import lotto.dto.PurchaseAmountUserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmount implements Amount<Long> {
  private long amount;

  private PurchaseAmount (long amount) {
    this.amount = amount;
  }

  public static PurchaseAmount from(PurchaseAmountUserInput userInput) {
    return new PurchaseAmount(userInput.getAmount());
  }

  @Override
  public Long getAmount() {
    return this.amount;
  }

  public long calculatePurchasableCount(int price) {
    return getAmount() / price;
  }
}
