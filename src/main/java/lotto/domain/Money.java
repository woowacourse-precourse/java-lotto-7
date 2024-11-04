package lotto.domain;

import static lotto.constant.LottoConstant.UNIT_PRICE;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;
import lotto.util.ConvertInput;

public class Money {
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(String input) {
        int money = ConvertInput.makeMoneyToInt(input);
        validate(money);
        return new Money(money);
    }

    public int calculateTicketCount() {
        return money / UNIT_PRICE;
    }

    public int getMoney() {
        return money;
    }

    private static void validate(int money) {
        validateNegativeNumber(money);
        validateLessThanUnitPrice(money);
        validateNotDividedUnitPrice(money);
    }

    private static void validateNegativeNumber(int money) {
        if (money < 0) {
            throw InputException.from(ErrorMessage.MONEY_IS_NEGATIVE_NUMBER);
        }
    }

    private static void validateLessThanUnitPrice(int money) {
        if (money < UNIT_PRICE) {
            throw InputException.from(ErrorMessage.MONEY_IS_LESS_THAN_UNIT_PRICE);
        }
    }

    private static void validateNotDividedUnitPrice(int money) {
        if (money % UNIT_PRICE != 0) {
            throw InputException.from(ErrorMessage.MONEY_IS_NOT_DIVIDED_BY_UNIT_PRICE);
        }
    }
}
