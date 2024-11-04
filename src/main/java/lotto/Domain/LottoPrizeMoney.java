package lotto.Model;

public enum LottoPrizeMoney {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private final int rank;
    private final int prizeMoney;
    private final int matchNumber;

    LottoPrizeMoney(int rank, int matchNumber, int prizeMoney) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public static LottoPrizeMoney fromRank(int i) {
        for (LottoPrizeMoney prize : LottoPrizeMoney.values()) {
            if (prize.getRank() == i) {
                return prize;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 순위: " + i);
    }
}
