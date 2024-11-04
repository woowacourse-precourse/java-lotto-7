package lotto.validation;

import static lotto.constant.ErrorMessageConstants.NEGATIVE_NUMBER;
import static lotto.constant.ErrorMessageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000;
import static lotto.constant.ErrorMessageConstants.VALUE_IS_NOT_NUMBER;

public class MoneyValidation {

    public void isNumber(String money) {
        long longMoney;
        try {
            longMoney = Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALUE_IS_NOT_NUMBER);
        }
    }

    public void validation(long money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        } else if (money % 1000 != 0) {
            throw new IllegalArgumentException(VALUE_IS_NOT_DIVISIBLE_BY_1000);
        }
    }
}
