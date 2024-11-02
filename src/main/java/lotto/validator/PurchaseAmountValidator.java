package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.PurchaseAmountValidatorConstant;

import java.math.BigInteger;

public class PurchaseAmountValidator {
    public void validate(String purchaseAmountRawInput) {
        if (!isPositiveNumber(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
        if (hasWhiteSpace(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_IN_PURCHASE_AMOUNT.getMessage());
        }
        if (isOutOfRangePurchaseAmount(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_PURCHASE_AMOUNT.getMessage());
        }
        if (!canDivideByThousand(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isPositiveNumber(String str) {
        return str.matches("\\+?\\d+");
    }

    private boolean hasWhiteSpace(String str) {
        return str.matches(".*\\s+.*");
    }

    private boolean isOutOfRangePurchaseAmount(String purchaseAmount) {
        BigInteger amount = new BigInteger(purchaseAmount);
        BigInteger minAmount = BigInteger.valueOf(PurchaseAmountValidatorConstant.MIN_PURCHASE_AMOUNT.getValue());
        BigInteger maxAmount = BigInteger.valueOf(PurchaseAmountValidatorConstant.MAX_PURCHASE_AMOUNT.getValue());

        return amount.compareTo(minAmount) < 0 || amount.compareTo(maxAmount) > 0;
    }

    private boolean canDivideByThousand(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);

        return amount % PurchaseAmountValidatorConstant.THOUSAND.getValue() == 0;
    }
}
