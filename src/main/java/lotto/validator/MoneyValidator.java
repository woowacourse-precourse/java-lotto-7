package lotto.validator;

import static lotto.constant.ErrorCode.*;
import static lotto.constant.LottoConfig.*;

public class MoneyValidator {
    private MoneyValidator() {
    }

    public static void isNumeric(String value) {
        try {
            int money = Integer.parseInt(value);
        } catch (Exception e) {
            throw new NumberFormatException(INVALID_MONEY.getMessage());
        }
    }

    public static void isPositive(String value) {
        int money = Integer.parseInt(value);
        if (money <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MONEY.getMessage());
        }
    }

    public static void checkDivisibleByThousand(String value) {
        int money = Integer.parseInt(value);
        if ((money % LOTTO_TICKET_PRICE.getValue()) != 0) {
            throw new IllegalArgumentException(DIVISION_BY_LOTTO_PRICE.getMessage());
        }
    }
}
