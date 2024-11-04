package lotto.parser;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionCode;
import lotto.validation.LottoTokenValidator;

public class LottoTokenizer {
    public static int getPurchaseMoney(String token) throws LottoException {
        try {
            int purchaseMoney = Integer.parseInt(token);
            LottoTokenValidator.validatePurchaseNumber(purchaseMoney);
            return purchaseMoney;
        }catch (NumberFormatException exception) {
            throw new LottoException(LottoExceptionCode.PURCHASE_MONEY_FORMAT_ERROR);
        }
    }

    public static int getLottoNumber(String token) throws LottoException {
        try {
            int lottoNumber = Integer.parseInt(token);
            LottoTokenValidator.validateLottoNumber(lottoNumber);
            return lottoNumber;
        }catch (NumberFormatException exception) {
            throw new LottoException(LottoExceptionCode.LOTTO_NUMBER_FORMAT_ERROR);
        }
    }
}
