package lotto.exceptions;

import lotto.util.LottoErrorMessages;

public class LottoNumberFormatException extends LottoException {
    public LottoNumberFormatException() {
        super(LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_INVALID_INPUT_FORMAT);
    }

    @Override
    public String getErrorMessage() {
      return LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_INVALID_INPUT_FORMAT;
    }
}
