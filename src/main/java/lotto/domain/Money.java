package lotto.domain;

import lotto.exception.DivideMoneyException;

public class Money {
    private final int money;

    public Money(int money) {
        validateDivide(money);
        this.money = money;
    }

    private void validateDivide(int money) {
        if (!(money % 1000 == 0)) {
            throw new DivideMoneyException();
        }
    }

    public int getTicket() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
