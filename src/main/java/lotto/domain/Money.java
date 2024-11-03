package lotto.domain;

import lotto.constants.Constants;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        validateIsZero(money);
        validateThousandUnit(money);
    }

    private void validateIsZero(int money) {
        if (money == Constants.ZERO.getValue()) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_ZERO);
        }
    }

    private void validateThousandUnit(int money) {
        if (money % Constants.ONE_THOUSAND.getValue() != Constants.ZERO.getValue()) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT);
        }
    }
}
