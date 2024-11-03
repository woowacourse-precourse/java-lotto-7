package lotto.exception;

import lotto.enums.ErrorType;

public class CheckInput {

    public static boolean checkInputMoney(int inputMoney) {
        if (inputMoney < 1000) {
            System.out.println(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage());
            return false;
        }

        if (inputMoney % 1000 != 0) {
            System.out.println(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage());
            return false;
        }

        return true;
    }

}