package lotto.validator;

import lotto.enums.Constants;
import lotto.enums.ErrorMessages;

public class LottoValidator {

    public static void validateInputMoney(String inputMoney) {
        isEmpty(inputMoney);
        isDigit(inputMoney);
        int money = Integer.parseInt(inputMoney);
        if (money % Constants.MONEY_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNIT.getMessage(Constants.MONEY_UNIT.getValue()));
        }
    }

    private static void isEmpty(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOTHING.getMessage());
        }
    }

    private static void isDigit(String inputMoney) {
        if (!inputMoney.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_FORMAT.getMessage());
        }
    }
}