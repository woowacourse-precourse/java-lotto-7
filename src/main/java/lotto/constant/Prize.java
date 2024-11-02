package lotto.constant;

public enum Prize {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int match;
    private final int money;
    private final boolean bonus;

    Prize(int match, int money, boolean bonus) {
        this.match = match;
        this.money = money;
        this.bonus = bonus;
    }

    public int getMoney() {
        return money;
    }

    public static Prize getPrize(int match, boolean bonus) {
        for (Prize prize : values()) {
            if (prize.match == match && prize.bonus == bonus) {
                return prize;
            }
        }
        return NONE;
    }
}
