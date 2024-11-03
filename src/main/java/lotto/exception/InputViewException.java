package lotto.exception;

import lotto.constants.ExceptionsMessageConstants;

public class InputViewException {

    public void validateInputMoney(String inputMoney){
        validateMoneyFormat(inputMoney);
        validateIfMoneyPositive(inputMoney);
    }

    private void validateMoneyFormat(String inputMoney){
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_MUST_BE_NUMERIC);
        }
    }

    private void validateIfMoneyPositive(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        if (money <= 0) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_NUMBER_MUST_BE_POSITIVE);
        }
    }

}
