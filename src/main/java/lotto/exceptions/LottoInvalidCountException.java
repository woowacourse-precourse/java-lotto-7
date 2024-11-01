package lotto.exceptions;

import lotto.model.Lotto;
import lotto.util.LottoErrorMessages;

public class LottoInvalidCountException extends LottoException {
  public LottoInvalidCountException() {
    super(LottoErrorMessages.ERROR_LOTTO_INVALID_COUNT);
  }

  @Override
  public String getErrorMessage() {
    return LottoErrorMessages.ERROR_LOTTO_INVALID_COUNT;
  }
}