package lotto.domain;

public enum MatchResult {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final double prize;
    private final String description;

    MatchResult(int matchCount, double prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}