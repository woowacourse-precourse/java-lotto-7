package lotto.exception;

import lotto.constants.ExceptionsMessageConstants;

public class InputViewException {

    public void validateInputMoney(String inputMoney){
        validateMoneyFormat(inputMoney);
    }

    private void validateMoneyFormat(String inputMoney){
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_MUST_BE_NUMERIC);
        }
    }

}
