package lotto.config;

import static lotto.config.LottoConfig.NUMBER_COUNT;

public enum Prize {
    FIRST(NUMBER_COUNT, false, 2_000_000_000),
    SECOND(NUMBER_COUNT - 1, true, 30_000_000),
    THIRD(NUMBER_COUNT - 2, false, 1_500_000),
    FOURTH(NUMBER_COUNT - 3, false, 50_000),
    FIFTH(NUMBER_COUNT - 4, false, 5_000);

    private final int count;
    private final boolean needBonus;
    private final int money;

    Prize(int count, boolean needBonus, int money) {
        this.count = count;
        this.needBonus = needBonus;
        this.money = money;
    }

    public int getCount() {
        return count;
    }
    public boolean isNeedBonus() {
        return needBonus;
    }
    public int getMoney() {
        return money;
    }
}
