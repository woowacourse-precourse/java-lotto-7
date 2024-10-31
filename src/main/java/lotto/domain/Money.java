package lotto.domain;

import lotto.exception.ErrorMessage;

public class Money {

    private static final int DIVIDE_STANDARD = 1000;
    private static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        validateGreaterThanAThousand(money);
        validateMultipleOfThousand(money);
    }

    private void validateGreaterThanAThousand(int money) {
        if (money < DIVIDE_STANDARD) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_GREATER_THAN_A_THOUSAND.getMessage());
        }
    }

    private void validateMultipleOfThousand(int money) {
        if (money % DIVIDE_STANDARD != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}
