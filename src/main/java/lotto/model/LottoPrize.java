package lotto.model;

public enum LottoPrize {
    MATCH_COUNT_3(3, 5000),
    MATCH_COUNT_4(4, 50000),
    MATCH_COUNT_5(5, 1500000),
    MATCH_COUNT_6(6, 2000000000),
    MATCH_COUNT_5_WITH_BONUS(7, 30000000);

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
