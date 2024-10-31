package lotto.validator;

import lotto.constants.InputError;
import lotto.constants.LottoConstInteger;
import lotto.view.ErrorPrinter;

public class PurchasePriceValidator {
    public static boolean validate(String rawPurchasePrice) {
        if (!isExist(rawPurchasePrice)) {
            return false;
        }
        if (!isNumber(rawPurchasePrice)) {
            return false;
        }
        if (!isOverFlow(rawPurchasePrice)) {
            return false;
        }
        int intPurchasePrice = Integer.parseInt(rawPurchasePrice);
        if (!isReachAtLeastPrice(intPurchasePrice)) {
            return false;
        }
        if (!isDividedClearly(intPurchasePrice)) {
            return false;
        }
        return true;
    }

    private static boolean isExist(String rawPurchasePrice) {
        if (rawPurchasePrice.isBlank()) {
            ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_SHOULD_EXIST);
            return false;
        }
        return true;
    }

    private static boolean isNumber(String rawPurchasePrice) {
        boolean isDigit = rawPurchasePrice.chars()
                .allMatch(Character::isDigit);
        if (isDigit) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_NOT_A_NUMBER);
        return false;
    }

    private static boolean isOverFlow(String rawPurchasePrice) {
        if (rawPurchasePrice.compareTo(String.valueOf(Integer.MAX_VALUE)) <= 0) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_OVER_PROGRAM_MAX);
        return false;
    }

    private static boolean isReachAtLeastPrice(int intPurchasePrice) {
        if (intPurchasePrice >= LottoConstInteger.LOTTO_PRICE.getValue()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_NOT_REACH_AT_LEAST);
        return false;
    }

    private static boolean isDividedClearly(int intPurchasePrice) {
        if (intPurchasePrice % LottoConstInteger.LOTTO_PRICE.getValue() == 0) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_SHOULD_BE_DIVIDED_CLEARLY);
        return false;
    }
}
