package lotto.model;

import static lotto.enums.Constants.MONEY_UNIT;
import static lotto.enums.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.enums.ExceptionMessage.ZERO_EXCEPTION;

public class Money {
    private final Integer money;

    public Money(Integer money) {
        validateUnit(money);
        validateZero(money);
        this.money = money;
    }

    public void validateUnit(int money) {
        if (money % MONEY_UNIT.getValue() !=0){
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    public void validateZero(int money) {
        if (money==0){
            throw new IllegalArgumentException(ZERO_EXCEPTION.getMessage());
        }
    }

    public Integer getMoney() {
        return money;
    }
}
