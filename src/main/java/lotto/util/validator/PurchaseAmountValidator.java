package lotto.util.validator;

import static lotto.constants.GlobalLottoConst.MAX_PURCHASE_AMOUNT;
import static lotto.constants.GlobalLottoConst.UNIT;
import static lotto.message.ErrorMessage.INVALID_UNIT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.NOT_POSITIVE_INTEGER_INPUT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE;


public class PurchaseAmountValidator {

    public static void validate(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
        validateMaxPurchaseAmount(purchaseAmount);
        validateThousandWonUnit(purchaseAmount);
    }

    private static void validatePositiveNumber(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_INPUT_ERROR_MESSAGE.getContent());
        }
    }

    private static void validateMaxPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE.getContent());
        }
    }

    private static void validateThousandWonUnit(int purchaseAmount) {
        if (purchaseAmount % UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR_MESSAGE.getContent());
        }
    }
}
