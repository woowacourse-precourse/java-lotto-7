package lotto.enums;

public enum LottoPrizes {

    FIFTH(3, "5,000", 0),
    FOURTH(4, "50,000", 0),
    THIRD(5, "1,500,000", 0),
    SECOND(5, "30,000,000", 0),
    FIRST(6, "2,000,000,000", 0),
    ;


    private final int matchNumberCount;

    private final String prizeMoney;

    private int count;

    LottoPrizes(int matchNumberCount, String prizeMoney, int count) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public static void checkLottoRank(long matchingCount, boolean isBonusMatched) {
        if (matchingCount == 6) {
            FIRST.count++;
        }

        if (matchingCount == 5 && isBonusMatched) {
            SECOND.count++;
        }

        if (matchingCount == 5) {
            THIRD.count++;
        }

        if (matchingCount == 4) {
            FOURTH.count++;
        }

        if (matchingCount == 3) {
            FIFTH.count++;
        }
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getCount() {
        return this.count;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public int moneyToInt() {
        int[] prizeValues = {5000, 50000, 1500000, 30000000, 2000000000};
        return prizeValues[ordinal()];
    }
}
