package lotto.domain;

import java.math.BigDecimal;
import lotto.util.ErrorMessages;
import lotto.util.LottoConstants;

public record PurchaseAmount(BigDecimal amount) {

  public PurchaseAmount {
    validate(amount);
  }

  private void validate(BigDecimal amount) {
    if (amount.compareTo(LottoConstants.LOTTO_PRICE) < 0) {
      throw new IllegalArgumentException(ErrorMessages.AMOUNT_MIN);
    }
    if (amount.remainder(LottoConstants.LOTTO_PRICE).compareTo(BigDecimal.ZERO) != 0) {
      throw new IllegalArgumentException(ErrorMessages.AMOUNT_UNIT);
    }
  }
}
