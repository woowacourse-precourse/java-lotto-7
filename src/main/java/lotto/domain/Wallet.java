package lotto.domain;

import lotto.exception.MoneyException;
import lotto.message.ExceptionMessage;

public class Wallet {

    private static final Integer MIN_MONEY_UNIT = 1000;
    private static final Integer MIN_MONEY_UNIT_CHECK_NUMBER = 0;

    private final Integer money;

    public Wallet(Integer money) {
        validatePositive(money);
        validateUnit(money);
        this.money = money;
    }

    private void validatePositive(Integer money) {
        if (money <= MIN_MONEY_UNIT_CHECK_NUMBER) {
            throw new MoneyException(ExceptionMessage.INPUT_BONUS_RANGE_EXCEPTION);
        }
    }

    private void validateUnit(Integer money) {
        if (money % MIN_MONEY_UNIT != MIN_MONEY_UNIT_CHECK_NUMBER) {
            throw new MoneyException(ExceptionMessage.INPUT_MONEY_UNIT_EXCEPTION);
        }
    }

    public Integer getMoney() {
        return money;
    }
}
