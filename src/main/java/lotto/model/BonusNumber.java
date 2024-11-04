package lotto.model;

import lotto.view.constant.ErrorConstant;
import lotto.view.constant.ValidatorConstant;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = strToInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        if (!isEntered(bonusNumber))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_ENTERED);
        if (!isNumber(bonusNumber))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_NUMBER);
        if (!isWithinValidRange(bonusNumber))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_WITHIN_VALID_RANGE);
    }

    private int strToInt(String s) {
        return Integer.parseInt(s);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private boolean isEntered(String s) {
        return !s.isEmpty();
    }

    private boolean isNumber(String s) {
        return ValidatorConstant.NUMBER_PATTERN.matcher(s).matches();
    }

    private boolean isWithinValidRange(String s) {
        return Integer.parseInt(s) >= ValidatorConstant.MIN_NUMBER
                && Integer.parseInt(s) <= ValidatorConstant.MAX_NUMBER;
    }
}
