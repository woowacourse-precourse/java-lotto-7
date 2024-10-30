package lotto.utils.validator;

import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;
import static lotto.utils.ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;

public class PurchaseAmountValidator extends Validator {

    @Override
    public void validate(String userInput) {
        validateEmpty(userInput);
        validateNumber(userInput, PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
    }

    public void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT || (purchaseAmount % MIN_PURCHASE_AMOUNT != 0)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
        }
    }
}
