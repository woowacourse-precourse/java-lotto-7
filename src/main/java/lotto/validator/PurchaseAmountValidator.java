package lotto.validator;

import static lotto.constants.Constants.LOTTO_PRICE;
import static lotto.constants.ErrorStringConstants.*;

public class PurchaseAmountValidator {

    public void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE.getValue() || amount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE.getValue());
        }
    }
}
