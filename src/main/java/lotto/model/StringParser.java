package lotto.model;

import static lotto.constant.ErrorMessage.INTEGER_ERROR;
import static lotto.constant.ErrorMessage.THOUSANDS_ERROR;

public class StringParser {
    static final int UNIT_AMOUNT = 1000;

    public Integer findAmount(String rawAmount) {
        try {
            int amount = Integer.parseInt(rawAmount);
            return validateAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR.getMessage());
        }
    }

    private Integer validateAmount(int amount) {
        if ((amount % UNIT_AMOUNT) != 0) {
            return amount / UNIT_AMOUNT;
        }
        throw new IllegalArgumentException(THOUSANDS_ERROR.getMessage());
    }
}
