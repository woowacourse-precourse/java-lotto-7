package lotto.model;

public enum LottoRank {
    FIRST(6, 2000000000L, "6개 일치"),
    SECOND(5, 30000000L, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1500000L, "5개 일치"),
    FOURTH(4, 50000L, "4개 일치"),
    FIFTH(3, 5000L, "3개 일치");

    private final int matchingCount;
    private final long prizeAmount;
    private final String description;

    LottoRank(int matchingCount, long prizeAmount, String description) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }
}
