package lotto.domain;

import static lotto.constant.Constant.LOTTO_PRICE;

import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
        validateMoney();
    }

    private void validateMoney() {
        validatePositive();
        validateDivisibleByThousand();
    }

    private void validatePositive() {
        if (money < 1) {
            throw new LottoException(ExceptionCode.NEGATIVE_NUMBER);
        }
    }

    private void validateDivisibleByThousand() {
        if (money % LOTTO_PRICE != 0) {
            throw new LottoException(ExceptionCode.NON_DIVISIBLE_BY_THOUSAND);
        }
    }

    public int getMoney() {
        return money;
    }
}
