package lotto.vo;

import lotto.util.Parser;
import lotto.util.Validator;

import static lotto.common.ErrorMessage.INTEGER_RANGE_EXCESS;
import static lotto.common.ErrorMessage.NOT_NUMBER_OR_RANGE_EXCESS;

public class Payment {
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
        Validator.checkNegative(money);
        Validator.checkMultiplesOfThousand(money);
    }
}
