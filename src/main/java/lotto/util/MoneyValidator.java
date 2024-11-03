package lotto.util;

import lotto.enums.ErrorMessage;
import lotto.enums.PriceConstants;

public final class MoneyValidator extends Validator {
    public static void validate(String input) {
        checkNumberForm(input);

        int money = Integer.parseInt(input);
        checkThousandUnit(money);
    }

    private static void checkThousandUnit(int money) {
        if (money < PriceConstants.LOTTO_PRICE || money % PriceConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.format());
        }
    }
}
