package lotto.exception;

import lotto.enums.ErrorType;

public class CheckInput {

    public static void checkInputMoney(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage());
        }

        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage());
        }
    }

}
