package lotto.validation;

import lotto.view.constant.ErrorConstant;
import lotto.view.constant.ValidatorConstant;

public class LottoPurchaseAmountValidator {
    public void validateLottoPurchaseAmount(String inputLottoPurchaseAmount) {
        if (!isEntered(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_ENTERED);
        if (!isNumber(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_NUMBER);
        if (!isPositive(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_POSITIVE);
        if (!isMultipleOfThousand(inputLottoPurchaseAmount))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_MULTIPLE_OF_THOUSAND);
    }

    private boolean isEntered(String s) {
        return !s.isEmpty();
    }

    private boolean isNumber(String s) {
        return ValidatorConstant.NUMBER_PATTERN.matcher(s).matches();
    }

    private boolean isPositive(String s) {
        return Integer.parseInt(s) > 0;
    }

    private boolean isMultipleOfThousand(String s) {
        return Integer.parseInt(s) % 1000 == 0;
    }
}
