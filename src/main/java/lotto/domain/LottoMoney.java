package lotto.domain;

import lotto.util.ErrorMessage;

public class LottoMoney {

    public static final int LOTTO_PRICE = 1000;
    public static final int MONEY_MAX = 1_000_000;

    private final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    public int calculateLottoCount() {
        return money / LOTTO_PRICE;
    }

    public int money() {
        return money;
    }

    private void validate(int money) {
        validateMoneyLessThenMax(money);
        validateMoneyLessThenZero(money);
        validateMoneyModLottoPrice(money);
    }

    private void validateMoneyModLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_MODED_PRICE.getMsg());
        }
    }

    private void validateMoneyLessThenZero(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LESS_THEN_MINIMUM.getMsg());
        }
    }

    private void validateMoneyLessThenMax(int money) {
        if (money > MONEY_MAX) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MORE_THEN_MAXIMUM.getMsg());
        }
    }
}
