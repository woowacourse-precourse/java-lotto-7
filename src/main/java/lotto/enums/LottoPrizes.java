package lotto.enums;

public enum LottoPrizes {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(3, 50000),
    FIFTH(2, 5000),
    NO_PRIZE(0, 0)
    ;

    private final int matchNumberCount;
    private final int prizeMoney;
    private static int count;

    LottoPrizes(int matchNumberCount, int prizeMoney) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
        count = 0;
    }

    public static LottoPrizes checkLottoRank(long matchingCount) {
        for (LottoPrizes prize : LottoPrizes.values()) {
            if (prize.matchNumberCount == matchingCount) {
                prize.count++;
                return prize;
            }
        }
        return NO_PRIZE;
    }

    public static int getCount() {
        return count;
    }
}
