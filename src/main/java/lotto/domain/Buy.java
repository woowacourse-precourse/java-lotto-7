package lotto.domain;

import static lotto.global.Error.MONEY_NOT_DIVISIBLE_1000;
import static lotto.global.Error.MONEY_NOT_POSITIVE;

public class Buy {

    private static final int THOUSAND = 1000;
    private final int money;
    private int lottoCounts;

    public Buy(int money) {
        validateMoney(money);
        this.money = money;
    }

    public void calculateLottoCounts() {
        this.lottoCounts = money / THOUSAND;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCounts() {
        return lottoCounts;
    }

    private void validateMoney(int money) {
        try {
            validateNotPositive(money);
            validateNotDivisibleBy1000(money);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateNotPositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_NOT_POSITIVE.getErrorMsg());
        }
    }

    private void validateNotDivisibleBy1000(int money) {
        if (money % THOUSAND != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVISIBLE_1000.getErrorMsg());
        }
    }
}
