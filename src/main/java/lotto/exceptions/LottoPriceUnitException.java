package lotto.exceptions;
import lotto.util.LottoErrorMessages;

public class LottoPriceUnitException extends LottoException {
    public LottoPriceUnitException() {
        super(LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_PRICE_UNIT_1000);
    }

    @Override
    public String getErrorMessage() {
        return LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_PRICE_UNIT_1000;
    }

}
