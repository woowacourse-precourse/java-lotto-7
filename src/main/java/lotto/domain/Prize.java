package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {
    FIFTH_PRIZE(3, false, 5_000),
    FOURTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 30_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000),
    ;

    private final int equalLottoCount;
    private final boolean isMatchBonus;
    private final long money;

    Prize(int winningLottoMatchCount, boolean isMatchBonus, long money) {
        this.equalLottoCount = winningLottoMatchCount;
        this.isMatchBonus = isMatchBonus;
        this.money = money;
    }

    public static Optional<Prize> findPrize(int equalLottoCount, boolean isMatchBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.equalLottoCount == equalLottoCount)
                .filter(prize -> equalLottoCount != 5 || prize.isMatchBonus == isMatchBonus)
                .findFirst();
    }

    public long getMoney() {
        return money;
    }

    public int getEqualLottoCount() {
        return equalLottoCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}
