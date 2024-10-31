package lotto.domain;

import java.math.BigDecimal;

public class PurchaseAmount {
  private static final BigDecimal MIN_AMOUNT = BigDecimal.valueOf(1000);
  private static final BigDecimal UNIT_AMOUNT = BigDecimal.valueOf(1000);

  private final BigDecimal amount;

  public PurchaseAmount(BigDecimal amount) {
    validate(amount);
    this.amount = amount;
  }

  private void validate(BigDecimal amount) {
    if (amount.compareTo(MIN_AMOUNT) < 0) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
    }
    if (amount.remainder(UNIT_AMOUNT).compareTo(BigDecimal.ZERO) != 0) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
  }

  public BigDecimal getAmount() {
    return amount;
  }

}
