package lotto.domain;

public enum Rank {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;  // 일치하는 숫자 개수
    private final int prize;       // 당첨 상금
    private final String displayName;

    Rank(int matchCount, int prize, String displayName) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.displayName = displayName;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return SIX_MATCH;
        if (matchCount == 5 && bonusMatch) return FIVE_MATCH_BONUS;
        if (matchCount == 5) return FIVE_MATCH;
        if (matchCount == 4) return FOUR_MATCH;
        if (matchCount == 3) return THREE_MATCH;
        return null;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
