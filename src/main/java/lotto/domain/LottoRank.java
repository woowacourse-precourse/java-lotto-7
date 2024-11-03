package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)");

    private final int matchCount;
    private final int prizeAmount;
    private final String description;

    LottoRank(int matchCount, int prizeAmount, String description) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }
}
