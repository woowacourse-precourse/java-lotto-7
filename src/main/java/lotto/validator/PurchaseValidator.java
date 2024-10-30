package lotto.validator;

import lotto.validator.exception.ErrorMessage;
import lotto.validator.exception.LottoException;

public class PurchaseValidator {

    public void validateProcess(String purchaseAmount) {
        validateIsNumber(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private void validateIsNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_NOT_NUMBER);
        }
    }
    private void validateThousandUnit(String convertedPurchaseAmount) {
        if(Integer.parseInt(convertedPurchaseAmount) % 1000 != 0) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT);
        }
    }
}
