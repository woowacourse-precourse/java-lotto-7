package lotto.model;

public enum LottoRank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    FIVE(3, 5000, "3개 일치 (5,000원)"),
    MISS(0, 0, "낙첨");

    LottoRank(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    private final int matchCount;
    private final int prize;
    private final String message;


    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return message;
    }

    public static LottoRank getRank(int matchCount, boolean isBonusNumber) {
        if (SECOND.matchCount(matchCount) && isBonusNumber) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount(matchCount) && rank != SECOND) {
                return rank;
            }
        }
        return MISS;
    }

    public boolean matchCount(int number) {
        return this.matchCount == number;
    }
}

