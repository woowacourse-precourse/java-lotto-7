package lotto.model;

public enum LottoMatchResult {
    THREE_MATCH(3, 5000, "3개 일치"),
    FOUR_MATCH(4, 50000, "4개 일치"),
    FIVE_MATCH(5, 1500000, "5개 일치"),
    FIVE_MATCH_WITH_BONUS(51, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoMatchResult(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }

    public String getDescription(){
        return description;
    }

    public static LottoMatchResult getByMatchCount(int matchCount) {
        for (LottoMatchResult stats : LottoMatchResult.values()) {
            if (stats.getMatchCount() == matchCount) {
                return stats;
            }
        }
        return null;
    }

}
