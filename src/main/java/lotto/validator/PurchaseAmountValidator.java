package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.GlobalConstant;

public class PurchaseAmountValidator {

    public void validate(String amount) {
        validatePositiveInteger(amount);
        validateUnit(amount);
        validateLimit(amount);
    }

    private void validatePositiveInteger(String amount) {
        if (!amount.matches(GlobalConstant.NUMBER_REGEX.value())) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NON_INTEGER_ERROR.toString());
        }
    }

    private void validateLimit(String amount) {
        if (!(Integer.parseInt(amount) % GlobalConstant.UNIT.intValue() == 0)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_MULTIPLE_OF_LIMIT_ERROR.toString());
        }
    }

    private void validateUnit(String amount) {
        if (Integer.parseInt(amount) < GlobalConstant.UNIT.intValue()) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_BELOW_MINIMUM_ERROR.toString());
        }
    }
}
