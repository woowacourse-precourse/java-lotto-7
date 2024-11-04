package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;
import lotto.model.LottoConstants;

public class MoneyValidator {

    private static final int ZERO = 0;

    public void validateMoney(int money) {
        validateIsMoreThanThousand(money);
        validateIsDivisibleByThousand(money);
    }

    private void validateIsMoreThanThousand(int money) {
        if (isLessThanThousand(money)) {
            throw new LottoException(LottoErrorMessage.MONEY_LESS_THAN_THOUSAND);
        }
    }

    private boolean isLessThanThousand(int money) {
        return money < LottoConstants.LOTTO_PRICE.getValue();
    }

    private void validateIsDivisibleByThousand(int money) {
        if (isNotDivisibleByThousand(money)) {
            throw new LottoException(LottoErrorMessage.MONEY_NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private boolean isNotDivisibleByThousand(int money) {
        return money % LottoConstants.LOTTO_PRICE.getValue() != ZERO;
    }
}
