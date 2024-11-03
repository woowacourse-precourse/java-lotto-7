package lotto.domain;

import lotto.exception.Money.DivideMoneyException;
import lotto.exception.Money.NegativeMoneyException;

public class Money {
    private final int money;

    public Money(int money) {
        validatePositive(money);
        validateDivide(money);
        this.money = money;
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new NegativeMoneyException();
        }
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
