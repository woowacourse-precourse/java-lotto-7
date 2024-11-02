package lotto.model.amount;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 2.
 */
public class ProfitAmount implements Amount<Long> {
  private long amount;

  private ProfitAmount (long amount) {
    this.amount = amount;
  }

  public static ProfitAmount from(long amount) {
    return new ProfitAmount(amount);
  }

  @Override
  public Long getAmount() {
    return this.amount;
  }
}
