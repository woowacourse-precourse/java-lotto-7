package lotto;

public enum LottoRank {
    MATCH_3(3, 5000, "3개 일치 (5,000원)"),
    MATCH_4(4, 50000, "4개 일치 (50,000원)"),
    MATCH_5(5, 1500000, "5개 일치 (1,500,000원)"),
    MATCH_5_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}