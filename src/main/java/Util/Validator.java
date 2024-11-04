package Util;

import Constant.Constant;

public class Validator {
    public static void validateThousandUnit(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(Constant.ErrorConstant.PURCHASE_THOUSAND_ERROR);
        }
    }

    public static void validateIsNumber(Integer purchaseAmount) {
        try {
            Integer.parseInt(String.valueOf(purchaseAmount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.ErrorConstant.PURCHASE_WORD_INPUT_ERROR);
        }
    }
}
}
