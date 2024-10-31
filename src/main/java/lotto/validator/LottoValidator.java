package lotto.validator;

import lotto.enums.Constants;

public class LottoValidator {

    public static void validateInputMoney(String inputMoney) {
        isEmpty(inputMoney);
        isDigit(inputMoney);
        int money = Integer.parseInt(inputMoney);
        if (money % Constants.MONEY_UNIT.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void isEmpty(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDigit(String inputMoney) {
        if (!inputMoney.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}