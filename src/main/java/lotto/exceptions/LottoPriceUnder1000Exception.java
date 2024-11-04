package lotto.exceptions;
import lotto.util.LottoErrorMessages;

public class LottoPriceUnder1000Exception extends LottoException {
    public LottoPriceUnder1000Exception() {
        super(LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_PRICE_UNDER_1000);
    }

    @Override
    public String getErrorMessage() {
        return LottoErrorMessages.ERROR_FLAG + " " + LottoErrorMessages.ERROR_LOTTO_PRICE_UNDER_1000;
    }
}