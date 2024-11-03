package lotto.domain.player;

import static lotto.constant.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.constant.LottoConfig.LOTTO_COST;

public class Wallet {

    private final long initialMoney;
    private final long money;

    public Wallet(long money) {
        this(money, money);
    }

    private Wallet(long initialMoney, long money) {
        validate(initialMoney);
        this.initialMoney = initialMoney;
        this.money = money;
    }

    private void validate(long money) {
        if (money % LOTTO_COST != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    public Wallet useMoney(long money) {
        return new Wallet(this.initialMoney, this.money - money);
    }

    public long getInitialMoney() {
        return initialMoney;
    }

    public long getMoney() {
        return money;
    }
}
