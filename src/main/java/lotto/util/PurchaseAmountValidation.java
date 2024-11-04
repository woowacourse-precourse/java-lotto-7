package lotto.util;

import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

public class PurchaseAmountValidation {
    public static void ValidatePurchaseAmount(String purchaseAmount){
        validateNumericOnly(purchaseAmount);
        validateAmountLength(purchaseAmount);
        validateAmountUnit(purchaseAmount);
    }

    public static void validateNumericOnly(String purchaseAmount){
        if (!purchaseAmount.matches(GameConfig.VALID_DIGIT_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR);
        }
    }

    public static void validateAmountLength(String purchaseAmount){
        if (!purchaseAmount.matches(GameConfig.NUMERIC_AMOUNT_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.MAX_AMOUNT_ERROR);
        }
    }

    public static void validateAmountUnit(String purchaseAmount){
        if (!purchaseAmount.matches(GameConfig.VALID_UNIT_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT_ERROR);
        }
    }



}
