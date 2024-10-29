package lotto.buyer.infrastructure;

import lotto.buyer.domain.Money;
import lotto.buyer.validator.MoneyValidator;
import lotto.util.Convertor;

public class Won implements Money {
    private final Long money;
    private Won(Long money) {
        this.money = money;
    }
    public static Won of(String input) {
        Long money = Convertor.stringToLong(input);
        MoneyValidator.validate(money);
        return new Won(money);
    }

    @Override
    public Long getMoney() {
        return money;
    }
    @Override
    public String toString() {
        return money.toString();
    }
}
