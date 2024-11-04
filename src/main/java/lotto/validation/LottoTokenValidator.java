package lotto.validation;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;

public class LottoTokenValidator {
    public static void validatePurchaseNumber(int purchaseMoney) throws LottoException {
        if (purchaseMoney < 0) {
            throw new LottoException(LottoExceptionCode.PURCHASE_MONEY_FORMAT_ERROR);
        }
        if (purchaseMoney % 1000 != 0) {
            throw new LottoException(LottoExceptionCode.NEED_MULTIPLE_OF_THOUSAND);
        }
    }
    public static void validateLottoNumber(int lottoNumber) throws LottoException {
        if (lottoNumber < 0 || lottoNumber > 45)  {
            throw new LottoException(LottoExceptionCode.LOTTO_NUMBER_FORMAT_ERROR);
        }
    }
}
