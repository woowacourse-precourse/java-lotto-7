package lotto.Model;

public enum LottoPrize {
    FIRST(6, 1, 2000000000),
    SECOND(7, 2, 30000000),
    THIRD(5, 3, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(3, 5, 5000),
    NO_RANK(0, 0, 0)
    ;

    private final int sameCount;
    private final int rank;
    private final int money;

    LottoPrize(int sameCount, int rank, int money) {
        this.sameCount = sameCount;
        this.rank = rank;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getRank() {
        return rank;
    }

    public static LottoPrize getPrize(int rank) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.getRank() == rank) {
                return prize;
            }
        }
        return NO_RANK;
    }

    public static int getRank(int sameCount, boolean bonus) {
        for (LottoPrize prize : LottoPrize.values()) {
            int bonusCount = 0;
            if (sameCount == 5 && bonus) {
                bonusCount = 2;
            }
            if (prize.sameCount + bonusCount == sameCount) {
                return prize.rank;
            }
        }
        return 0;
    }
}
