package lotto.model;

import view.exception.LottoException;

public class Money {
    private static final String LOTTO_UNIT_ERROR = "구입금액은 1,000원 단위여야 합니다.";
    private static final int LOTTO_UNIT = 1000;
    private static final int PERCENT_MULTIPLY = 100;

    private final int money;

    public Money(int money) {
        validateUnit(money);
        this.money = money;
    }

    private void validateUnit(int money) {
        if (money % LOTTO_UNIT != 0 || money < 0) {
            throw new LottoException(LOTTO_UNIT_ERROR);
        }
    }

    public int calculateCountLotto() {
        return money / LOTTO_UNIT;
    }

    public int getMoney() {
        return money;
    }

    public double calculateProfitRatio(int profit) {
        return ((double) profit / money) * PERCENT_MULTIPLY;
    }
}
