package lotto.validator;

import lotto.enums.ErrorMessage;

public class MoneyTypeValidator {

    public int validateMoneyType(String inputMoney) {
        try {
            int money = Integer.parseInt(inputMoney);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_TYPE_ERROR.toString());
        }
    }
}
