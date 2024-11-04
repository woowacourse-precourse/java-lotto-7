package lotto.domain;

import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class Money {

    private static final String CHECK_NOT_NUMBER = "^[1-9]\\d*$";
    private static final int MONEY_DIVIDER = 1000;
    private static final int MONEY_REMAINDER = 0;

    private final int money;

    public static Money from(String lottoMoney) {
        validateEmptyMoney(lottoMoney);
        validateNotNumber(lottoMoney);
        int money = Integer.parseInt(lottoMoney);
        validateThousandMoney(money);
        return new Money(money);
    }

    private Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int buyLottos() {
        return money / MONEY_DIVIDER;
    }

    private static void validateEmptyMoney(String money) {
        if (money == null || money.isBlank()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_EMPTY_MONEY);
        }
    }

    private static void validateNotNumber(String money) {
        if (!money.matches(CHECK_NOT_NUMBER)) {
            throw new CustomException(CustomErrorCode.EXCEPTION_NOT_NUMBER_MONEY);
        }
    }

    private static void validateThousandMoney(int money) {
        if (money % MONEY_DIVIDER != MONEY_REMAINDER) {
            throw new CustomException(CustomErrorCode.EXCEPTION_NOT_THOUSAND_MONEY);
        }
    }
}
