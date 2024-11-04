package lotto.model.amount;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmount implements Amount {
  private int amount;

  @Override
  public int getAmount() {
    return this.amount;
  }

  public int calculatePurchasableCount(int price) {
    return getAmount() / price;
  }
}
