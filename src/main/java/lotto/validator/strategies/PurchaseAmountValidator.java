package lotto.validator.strategies;

import lotto.constants.LottoConstants;
import lotto.view.ErrorMessage;

public class PurchaseAmountValidator implements ValidationStrategy<Integer> {

    @Override
    public void validate(Integer amount) {
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }


}
