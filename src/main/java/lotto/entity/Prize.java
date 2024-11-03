package lotto.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    private final int match;
    private final boolean bonus;
    private final long money;

    Prize(int match, boolean bonus, long money) {
        this.match = match;
        this.bonus = bonus;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }

    public long getMoney() {
        return money;
    }

    public static Optional<Prize> getPrize(int match, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.match == match)
                .filter(prize -> {
                    if (prize.match == 5) {
                        return prize.bonus == bonus;
                    }
                    return true;
                })
                .findAny();
    }
}
