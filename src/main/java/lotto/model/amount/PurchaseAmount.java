package lotto.model.amount;

import lotto.dto.PurchaseAmountUserInput;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmount implements Amount<Integer> {
  private int amount;

  private PurchaseAmount (int amount) {
    this.amount = amount;
  }

  public static PurchaseAmount from(PurchaseAmountUserInput userInput) {
    return new PurchaseAmount(userInput.getAmount());
  }

  @Override
  public Integer getAmount() {
    return this.amount;
  }

  public int calculatePurchasableCount(int price) {
    return getAmount() / price;
  }
}
