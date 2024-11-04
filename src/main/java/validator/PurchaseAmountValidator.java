package validator;

import static view.message.ExceptionMessage.INVALID_UNIT_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LIMIT_EXCEED_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.MAX_PURCHASE_AMOUNT_TEN_THOUSAND;
import static view.message.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.THOUSAND_UNIT;

import java.math.BigDecimal;

public class PurchaseAmountValidator {

    public static void validatePurchaseAmount(BigDecimal purchaseAmount) {
        validateNegativeNumber(purchaseAmount);
        validatePurchaseAmountLimit(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private static void validateNegativeNumber(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validatePurchaseAmountLimit(BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(MAX_PURCHASE_AMOUNT_TEN_THOUSAND) > 0) {
            throw new IllegalArgumentException(LIMIT_EXCEED_EXCEPTION_MESSAGE);
        }
    }

    private static void validateThousandUnit(BigDecimal purchaseAmount) {
        if (purchaseAmount.remainder(THOUSAND_UNIT)
                          .compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_EXCEPTION_MESSAGE);
        }
    }
}
