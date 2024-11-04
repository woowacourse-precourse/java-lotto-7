package lotto.vo;

import lotto.util.Parser;
import lotto.util.Validator;

import static lotto.common.ErrorMessage.*;

public class Payment {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Payment(final String inputValue) {
        int money = parseToInt(inputValue);
        validate(money);
        this.money = money;
    }

    private int parseToInt(final String inputValue) throws IllegalArgumentException{
        try {
            return Parser.parseStringToInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_OR_RANGE_EXCESS.getMessage());
        }
    }

    private void validate(final int money) throws IllegalArgumentException {
        checkNegative(money);
        checkMultiplesOfThousand(money);
    }

    private void checkNegative(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage());
        }
    }

    private void checkMultiplesOfThousand(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException(MULTIPLES_OF_THOUSAND.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
