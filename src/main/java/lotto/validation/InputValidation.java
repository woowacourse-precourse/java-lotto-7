package lotto.validation;

import static lotto.constant.ErrorMessageConstants.NEGATIVE_NUMBER;
import static lotto.constant.ErrorMessageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000;
import static lotto.constant.ErrorMessageConstants.VALUE_IS_NOT_NUMBER;

import java.util.List;

public class InputValidation {

    public void isNumber(String money) {
        try {
            Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALUE_IS_NOT_NUMBER);
        }
    }

    public void moneyValidation(String money) {
        isNumber(money);
        int intMoney = Integer.parseInt(money);
        if (intMoney < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        } else if (intMoney % 1000 != 0) {
            throw new IllegalArgumentException(VALUE_IS_NOT_DIVISIBLE_BY_1000);
        }
    }

    public void convertValid(List<String> input) {
        for (String s : input) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(VALUE_IS_NOT_NUMBER);
            }
        }
    }
}
