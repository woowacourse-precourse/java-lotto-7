package lotto.validation;

import lotto.view.constant.ErrorConstant;

public class LottoPurchaseAmountValidator {
    private static boolean isEntered(String s) {
        return !s.isEmpty();
    }

    private static boolean isNumber(String s) {
        return s.matches("^[0-9]+$");
    }

    private static boolean isPositive(String s) {
        return Integer.parseInt(s) > 0;
    }

    private static boolean isMultipleOfThousand(String s) {
        return Integer.parseInt(s) % 1000 == 0;
    }

    public void validateLottoPurchaseAmount(String inputLottoPurchaseAmount) {
        if (!isEntered(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.NOT_ENTERED);
        if (!isNumber(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.NOT_NUMBER);
        if (!isPositive(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.NOT_POSITIVE);
        if (!isMultipleOfThousand(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.NOT_MULTIPLE_OF_THOUSAND);
    }
}
