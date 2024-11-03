package lotto.exception;

import lotto.constants.ExceptionsMessageConstants;

public class InputViewException {

    public void validateInputMoney(String inputMoney){
        validateMoneyFormat(inputMoney);
        validateIfMoneyPositive(inputMoney);
        validateIfMoneyMultipleOfThousand(inputMoney);
        validateIfMoneyStartsWithZero(inputMoney);
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

    private void validateIfMoneyMultipleOfThousand(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.MONEY_MUST_BE_A_MULTIPLE_OF_THOUSAND);
        }
    }

    private void validateIfMoneyStartsWithZero(String inputMoney) {
        if (!inputMoney.equals(String.valueOf(Integer.parseInt(inputMoney)))) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_NUMBER_CANNOT_START_WITH_ZERO);
        }
    }

}
