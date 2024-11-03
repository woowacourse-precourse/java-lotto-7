package lotto.domain;

import static lotto.handler.ConstantHandler.LOTTO_PRICE;
import static lotto.handler.ConstantHandler.MIN_MONEY_AMOUNT;
import static lotto.handler.ConstantHandler.MONEY_REMAINDER;
import static lotto.handler.ErrorHandler.INVALID_DIVISION;
import static lotto.handler.ErrorHandler.INVALID_POSITIVE;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getTicketCount() {
        return money / LOTTO_PRICE;
    }

    private void validate(int money) {
        validatePositive(money);
        validateDivision(money);
    }

    private void validatePositive(int money) {
        if (money <= MIN_MONEY_AMOUNT) {
            throw INVALID_POSITIVE.getException();
        }
    }

    private void validateDivision(int money) {
        if (money % LOTTO_PRICE != MONEY_REMAINDER) {
            throw INVALID_DIVISION.getException();
        }
    }
}
