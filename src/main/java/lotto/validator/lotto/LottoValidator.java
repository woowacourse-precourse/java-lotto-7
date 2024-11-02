package lotto.validator.lotto;

import lotto.domain.lotto.LottoConstant;
import lotto.error.lotto.LottoErrorMessage;

public class LottoValidator {

    public void validatePurchaseAmount(String amount) {
        validatePurchaseAmountType(amount);
        validatePurchaseAmountMultiple(amount);
    }

    private void validatePurchaseAmountType(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE);
        }
    }

    private void validatePurchaseAmountMultiple(String amount) {
        int amountOfInt = Integer.parseInt(amount);
        if (amountOfInt % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_PURCHASE_POLICY);
        }
    }
}
