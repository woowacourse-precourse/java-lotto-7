package lotto.validator;

import lotto.validator.exception.ErrorMessage;
import lotto.validator.exception.LottoException;

public class PurchaseValidator {

    private final static int THOUSAND = 1000;
    private final static int REMAIN = 0;

    public static void validateProcess(int purchaseAmount) {
        validateThousandUnit(purchaseAmount);
    }

    private static void validateThousandUnit(int convertedPurchaseAmount) {
        if(convertedPurchaseAmount % THOUSAND != REMAIN) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT);
        }
    }
}
