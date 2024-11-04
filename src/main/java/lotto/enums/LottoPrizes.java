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

    private  int count;
    LottoPrizes(int matchNumberCount, String prizeMoney, int count) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public static LottoPrizes checkLottoRank(long matchingCount, boolean isBonusMatched) {
        if (matchingCount == 6) {
            FIRST.count++;
            return FIRST;
        }

        if (matchingCount == 5 && isBonusMatched) {
            SECOND.count++;
            return SECOND;
        }

        if (matchingCount == 5) {
            THIRD.count++;
            return THIRD;
        }

        if (matchingCount == 4) {
            FOURTH.count++;
            return FOURTH;
        }

        if (matchingCount == 3) {
            FIFTH.count++;
            return FIFTH;
        }
        return null;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getCount() {
        return this.count;
    }

    public String  getPrizeMoney() {
        return prizeMoney;
    }

    public int moneyToInt(LottoPrizes prize) {
        if (prize == FIRST) {
            return 2000000000;
        }
        if (prize == SECOND) {
            return 30000000;
        }
        if (prize == THIRD) {
            return 1500000;
        }
        if (prize == FOURTH) {
            return 50000;
        }
        if (prize == FIFTH) {
            return 5000;
        }
        return 0;
    }
}
