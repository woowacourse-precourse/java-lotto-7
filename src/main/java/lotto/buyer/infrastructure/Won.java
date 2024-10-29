package lotto.buyer.infrastructure;

import lotto.buyer.domain.Money;

public class Won implements Money {
    private final Long money;
    public Won(String money) {
        this.money = Long.parseLong(money);
    }

    @Override
    public Long getMoney() {
        return money;
    }
}
