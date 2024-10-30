package lotto.model;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int hit;
    private final boolean bonus;
    private final int money;

    Prize(int hit, boolean bonus, int money) {
        this.hit = hit;
        this.bonus = bonus;
        this.money = money;
    }

    public static Prize findByHitAndBonus(int hit, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit)
                .filter(prize -> filterIfFiveHits(prize, bonus))
                .findAny()
                .orElse(null);
    }

    private static boolean filterIfFiveHits(Prize prize, boolean bonus) {
        if (prize.hit != 5) {
            return true;
        }

        return prize.bonus == bonus;
    }

    public int calculateResult(int count) {
        return this.money * count;
    }
}
