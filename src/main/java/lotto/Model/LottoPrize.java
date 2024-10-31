package lotto.Model;

public enum LottoPrize {
    FIRST(6, 2000000000, 1),
    SECOND(7, 30000000, 2),
    THIRD(5, 1500000, 3),
    FOURTH(4, 50000, 4),
    FIFTH(3, 5000, 5)
    ;

    private final int sameCount;
    private final int prizeMoney;
    private final int rank;

    LottoPrize(int sameCount, int prizeMoney, int rank) {
        this.sameCount = sameCount;
        this.prizeMoney = prizeMoney;
        this.rank = rank;
    }

    public int getPrizeMoney(int rank) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.rank == rank) {
                return prize.prizeMoney;
            }
        }
        return 0;
    }
    public int getRank(int sameCount, boolean bonus) {
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
