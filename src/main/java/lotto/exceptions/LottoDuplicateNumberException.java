package lotto.exceptions;
import lotto.util.LottoErrorMessages;

public class LottoDuplicateNumberException extends LottoException {
    public LottoDuplicateNumberException() {
        super(LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_DUPLICATE_NUMBER);
    }

    @Override
    public String getErrorMessage() {
        return LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_DUPLICATE_NUMBER;
    }
}