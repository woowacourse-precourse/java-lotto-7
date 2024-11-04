package lotto.model;

public enum Prize {
    FIRST(6, 1, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    NO_PRIZE(0, 0, 0);

    private final int matchCount;
    private final int bonusCount;
    private final int amount;

    Prize(int matchCount, int bonusCount, int amount) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.amount = amount;
    }

    public static int getIndex(int amount) {
        for (Prize prize : Prize.values()) {
            if (prize.getAmount() == amount) {
                return prize.ordinal();
            }
        }
        return -1;
    }

    public static int calculatePrize(int count, int bonusCount) {
        for (Prize prize : values()) {
            if (prize.matchCount == count && prize.bonusCount == bonusCount) {
                return prize.getAmount();
            }
        }
        return 0;
    }

    public int getAmount() {
        return amount;
    }

}
