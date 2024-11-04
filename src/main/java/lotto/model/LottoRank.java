package lotto.model;

public enum LottoRank {
    MATCH_THREE(3, 5_000, "3개 일치"),
    MATCH_FOUR(4, 50_000, "4개 일치"),
    MATCH_FIVE(5, 1_500_000, "5개 일치"),
    MATCH_FIVE_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    MATCH_SIX(6, 2_000_000_000, "6개 일치"),
    NONE(0, 0, "당첨 없음");

    private final int matchCount;
    private final long prize;
    private final String description;

    LottoRank(int matchCount, long prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank getRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return MATCH_SIX;
        }
        if (matchCount == 5 && matchBonus) {
            return MATCH_FIVE_BONUS;
        }
        if (matchCount == 5) {
            return MATCH_FIVE;
        }
        if (matchCount == 4) {
            return MATCH_FOUR;
        }
        if (matchCount == 3) {
            return MATCH_THREE;
        }
        return NONE;
    }
}