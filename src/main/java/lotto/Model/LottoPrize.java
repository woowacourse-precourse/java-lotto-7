package lotto.Model;

public enum LottoPrize {
    FIRST(6, 1),
    SECOND(7, 2),
    THIRD(5, 3),
    FOURTH(4, 4),
    FIFTH(3, 5),
    NO_RANK(0, 0)
    ;

    private final int sameCount;
    private final int rank;

    LottoPrize(int sameCount, int rank) {
        this.sameCount = sameCount;
        this.rank = rank;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getRank() {
        return rank;
    }

    public static LottoPrize getRank(int sameCount, boolean bonus) {
        for (LottoPrize prize : LottoPrize.values()) {
            int bonusCount = 0;
            if (sameCount == 5 && bonus) {
                bonusCount = 2;
            }
            if (prize.sameCount + bonusCount == sameCount) {
                return prize;
            }
        }
        return NO_RANK;
    }
}
