package lotto.exceptions;
import lotto.util.LottoErrorMessages;

public class LottoNumberRangeException extends LottoException {
    public LottoNumberRangeException() {
        super(LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_NUMBER_INVALID_RANGE);
    }

    @Override
    public String getErrorMessage() {
        return LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_NUMBER_INVALID_RANGE;
    }
}