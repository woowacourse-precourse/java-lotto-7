package lotto.validation;

import lotto.LottoConfig;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;

public class LottoTokenValidator {
    public static void validatePurchaseNumber(int purchaseMoney) throws LottoException {
        if (purchaseMoney < 0) {
            throw new LottoException(LottoExceptionCode.PURCHASE_MONEY_FORMAT_ERROR);
        }
        if (purchaseMoney % LottoConfig.LOTTO_PRICE != 0) {
            throw new LottoException(LottoExceptionCode.NEED_MULTIPLE_OF_THOUSAND);
        }
    }
    public static void validateLottoNumber(int lottoNumber) throws LottoException {
        if (lottoNumber < LottoConfig.LOTTO_START || lottoNumber > LottoConfig.LOTTO_END)  {
            throw new LottoException(LottoExceptionCode.LOTTO_NUMBER_FORMAT_ERROR);
        }
    }
}
