package lotto.validator;

import lotto.constants.InputError;
import lotto.constants.LottoInteger;
import lotto.view.ErrorPrinter;

public class PurchasePriceValidator {
    private static String rawPurchasePrice;
    private static int intPurchasePrice;

    /**
     * 로또 구입 금액의 유효성 검사를 진행한다.
     * 
     * @param rawPurchasePrice 유효성 검사가 필요한 로또 구입 금액
     * @return 유효한 로또 구입 금액이면 true, 아닐 경우 false
     */

    public static boolean validate(String rawPurchasePrice) {
        PurchasePriceValidator.rawPurchasePrice = rawPurchasePrice;
        if (!isExist()) {
            return false;
        }
        if (!isNumber()) {
            return false;
        }
        if (!isNotOverFlow()) {
            return false;
        }
        intPurchasePrice = Integer.parseInt(rawPurchasePrice);
        if (!isReachAtLeastPrice()) {
            return false;
        }
        if (!isDividedClearly()) {
            return false;
        }
        return true;
    }

    private static boolean isExist() {
        if (rawPurchasePrice.isBlank()) {
            ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_SHOULD_EXIST);
            return false;
        }
        return true;
    }

    private static boolean isNumber() {
        boolean isDigit = rawPurchasePrice.chars()
                .allMatch(Character::isDigit);
        if (isDigit) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_NOT_A_NUMBER);
        return false;
    }

    private static boolean isNotOverFlow() {
        try {
            intPurchasePrice = Integer.parseInt(rawPurchasePrice);
        } catch (NumberFormatException exception) {
            ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_OVER_PROGRAM_MAX);
            return false;
        }
        return true;
    }

    private static boolean isReachAtLeastPrice() {
        if (intPurchasePrice >= LottoInteger.LOTTO_PRICE.getValue()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_NOT_REACH_AT_LEAST);
        return false;
    }

    private static boolean isDividedClearly() {
        if (intPurchasePrice % LottoInteger.LOTTO_PRICE.getValue() == 0) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.PURCHASE_PRICE_SHOULD_BE_DIVIDED_CLEARLY);
        return false;
    }
}
