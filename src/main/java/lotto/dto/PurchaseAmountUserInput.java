package lotto.dto;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmountUserInput implements UserInput {
  private long amount;

  private PurchaseAmountUserInput (long amount) {
    this.amount = amount;
  }

  public static PurchaseAmountUserInput from(long amount) {
    return new PurchaseAmountUserInput(amount);
  }

  public long getAmount () {
    return this.amount;
  }
}
