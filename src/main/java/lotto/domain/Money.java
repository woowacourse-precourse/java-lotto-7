package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class Money {
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(String input) {
        int money = stringToInt(input);
        return new Money(money);
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw InputException.from(ErrorMessage.MONEY_HAS_CHARACTER);
        }
    }
}
