package lotto.buyer.infrastructure;

import lotto.buyer.domain.Money;
import lotto.buyer.validator.MoneyValidator;
import lotto.util.Convertor;

public class Won implements Money {
    private long money = 0L;
    public Won() {}
    private Won(long money) {
        this.money = money;
    }
    public static Won of(String input) {
        Long money = Convertor.stringToLong(input);
        MoneyValidator.validate(money);
        return new Won(money);
    }
    public static Won of(Long money) {
        return new Won(money);
    }


    @Override
    public Long getMoney() {
        return money;
    }

    @Override
    public void updateMoney(Money money) {
        this.money += money.getMoney();
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
