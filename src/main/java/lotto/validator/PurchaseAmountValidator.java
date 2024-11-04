package lotto.validator;

import java.math.BigInteger;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;

public class PurchaseAmountValidator {
    public static void validate(String purchaseAmountRawInput) {
        if (!isPositiveNumber(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
        if (hasWhiteSpace(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(WHITESPACE_IN_PURCHASE_AMOUNT.getMessage());
        }
        if (isOutOfRangePurchaseAmount(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_PURCHASE_AMOUNT.getMessage());
        }
        if (!canDivideByThousand(purchaseAmountRawInput)) {
            throw new IllegalArgumentException(NOT_DIVIDED_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isPositiveNumber(String str) {
        return str.matches("\\+?\\d+");
    }

    private static boolean hasWhiteSpace(String str) {
        return str.matches(".*\\s+.*");
    }

    private static boolean isOutOfRangePurchaseAmount(String purchaseAmount) {
        BigInteger amount = new BigInteger(purchaseAmount);
        BigInteger minAmount = BigInteger.valueOf(MIN_PURCHASE_AMOUNT.getValue());
        BigInteger maxAmount = BigInteger.valueOf(MAX_PURCHASE_AMOUNT.getValue());

        return amount.compareTo(minAmount) < 0 || amount.compareTo(maxAmount) > 0;
    }

    private static boolean canDivideByThousand(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);

        return amount % LOTTO_PRICE.getValue() == 0;
    }
}
