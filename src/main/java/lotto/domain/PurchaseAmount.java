package lotto.domain;

import java.math.BigDecimal;
import lotto.util.ErrorMessages;
import lotto.util.LottoConstants;

public class PurchaseAmount {
  private final BigDecimal amount;

  public PurchaseAmount(BigDecimal amount) {
    validate(amount);
    this.amount = amount;
  }

  private void validate(BigDecimal amount) {
    if (amount.compareTo(LottoConstants.LOTTO_PRICE) < 0) {
      throw new IllegalArgumentException(ErrorMessages.AMOUNT_MIN);
    }
    if (amount.remainder(LottoConstants.LOTTO_PRICE).compareTo(BigDecimal.ZERO) != 0) {
      throw new IllegalArgumentException(ErrorMessages.AMOUNT_UNIT);
    }
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
