package lotto.dto;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmountUserInput implements UserInput {
  int amount;

  private PurchaseAmountUserInput (int amount) {
    this.amount = amount;
  }

  public static PurchaseAmountUserInput from(Integer amount) {
    return new PurchaseAmountUserInput(amount);
  }
}
